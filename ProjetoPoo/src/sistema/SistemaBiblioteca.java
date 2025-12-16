package sistema;

import java.time.LocalDate;
import java.util.ArrayList;

public class SistemaBiblioteca {
    private ArrayList<Usuario> usuarios;
    private ArrayList<Item> itens;
    private ArrayList<Emprestimo> emprestimos;
    private ArrayList<ServicoComunitario> servicos;
    private ArrayList<Penalidade> penalidades;
    private Login login;
    private Usuario usuarioLogado;

    public SistemaBiblioteca() {
        usuarios = new ArrayList<>();
        itens = new ArrayList<>();
        emprestimos = new ArrayList<>();
        servicos = new ArrayList<>();
        penalidades = new ArrayList<>();
        login = new Login(usuarios);
    }

//Métodos de cadastro

    public void cadastrarUsuario(Usuario u) {
        usuarios.add(u);
    }

    public void adicionarItem(Item item) {
        itens.add(item);
    }

    public void adicionarServico(ServicoComunitario servico) {
        servicos.add(servico);
    }

  //Métodos de busca

    public Usuario buscarUsuarioPorCpf(String cpf) {
        for (Usuario u : usuarios) {
            if (u.getCpf().equals(cpf)) return u;
        }
        return null;
    }

    public Item buscarItemPorCodigo(int codigo) {
        for (Item i : itens) {
            if (i.getCodigo() == codigo) {
            	return i;
            }
        }
        return null;
    }

  //Métodos de login
    
    public boolean isAutenticado() {
        return usuarioLogado != null;
    }

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public boolean login(String user, String senha) {
        Usuario u = login.autenticar(user, senha);
        if (u != null) {
            usuarioLogado = u;
            return true;
        }
        return false;
    }

    public void logout() {
        usuarioLogado = null;
    }
    
  //Métodos do User
    
    public boolean isGerente() {
        return usuarioLogado != null &&
               usuarioLogado.getTipo() == TipoUsuario.GERENTE;
    }

    public boolean isVoluntario() {
        return usuarioLogado != null &&
               usuarioLogado.getTipo() == TipoUsuario.VOLUNTARIO;
    }


  //Métodos de penalidades

    private boolean usuarioPenalizado(Usuario u) {
        for (Penalidade p : penalidades) {
            if (p.getUsuario().equals(u) && p.estaAtiva()) {
                return true;
            }
        }
        return false;
    }
    
    public void aplicarPenalidade(Usuario usuario, String motivo, int dias) {
        Penalidade p = new Penalidade(usuario, motivo, dias);
        penalidades.add(p);
    }
    
    public void listarPenalidadesDoUsuario(Usuario u) {
        boolean encontrou = false;

        for (Penalidade p : penalidades) {
            if (p.getUsuario().equals(u)) {
                System.out.println(p.exibir());
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhuma penalidade encontrada.");
        }
    }

  //Métodos de empréstimo

    public void emprestarItem(int codigo, String cpf, LocalDate dataSaida, LocalDate dataDevolucaoPrevista) {
        try {
            Item item = buscarItemPorCodigo(codigo);
            Usuario usuario = buscarUsuarioPorCpf(cpf);

            if (item == null || usuario == null)
                throw new Exception("Item ou usuário inexistente");

            if (!item.isDisponivel())
                throw new Exception("Item indisponível");

            if (usuarioPenalizado(usuario))
                throw new Exception("Usuário penalizado");

            Emprestimo e = new Emprestimo(item, usuario, dataSaida, dataDevolucaoPrevista);
            e.registrar();

            emprestimos.add(e);
            usuario.getHistorico().adicionarEmprestimo(e);

        } catch (Exception e) {
            System.out.println("Erro no empréstimo: " + e.getMessage());
        }
    }


//Métodos de devolução

    public void devolverItem(int codigo) {
        for (Emprestimo e : emprestimos) {
            if (e.getItem().getCodigo() == codigo && e.estaPendente()) {
                e.devolver(LocalDate.now());

                if (e.getStatus() == StatusEmprestimo.ATRASADO) {
                    aplicarPenalidade(e.getUsuario(), "Devolução em atraso", 7);
                }
                return;
            }
        }
        System.out.println("Empréstimo não encontrado ou já devolvido.");
    }

  //Métodos de relatório

    public int getTotalUsuarios() {
        return usuarios.size();
    }

    public int getTotalItens() {
        return itens.size();
    }

    public int getItensDisponiveis() {
        int count = 0;
        for (Item i : itens) {
            if (i.isDisponivel()) count++;
        }
        return count;
    }

    public int getItensEmprestados() {
        return getTotalItens() - getItensDisponiveis();
    }

    public int getEmprestimosAtivos() {
        int count = 0;
        for (Emprestimo e : emprestimos) {
            if (e.estaPendente()) count++;
        }
        return count;
    }

    public int getTotalServicos() {
        return servicos.size();
    }
    
    public int getPenalidadesAtivas() {
        int count = 0;
        for (Penalidade p : penalidades) {
            if (p.estaAtiva()) count++;
        }
        return count;
    }
    
//Métodos de serviços
    
    public void listarServicos() {
        if (servicos.isEmpty()) {
            System.out.println("Nenhum serviço cadastrado.");
            return;
        }

        for (ServicoComunitario s : servicos) {
            System.out.println(s.resumo());
        }
    }
    
    public void inscreverEmServico(int id) {

        if (!isAutenticado()) {
            System.out.println("Você precisa estar logado.");
            return;
        }

        Usuario usuario = getUsuarioLogado();

        ServicoComunitario servico = null;

        for (ServicoComunitario s : servicos) {
            if (s.getId() == id) {
                servico = s;
                break;
            }
        }

        if (servico == null) {
            System.out.println("Serviço comunitário não encontrado.");
            return;
        }

        if (!servico.temVaga()) {
            System.out.println("Não há vagas disponíveis neste serviço.");
            return;
        }

        if (servico.estaInscrito(usuario)) {
            System.out.println("Você já está inscrito neste serviço.");
            return;
        }

        servico.inscrever(usuario);
        usuario.getHistorico().adicionarServico(servico);

        System.out.println("Inscrição realizada com sucesso!");
    }
    
//Métodos de permissão

    public boolean temPermissao(TipoUsuario... tipos) {
        if (!isAutenticado()) return false;

        TipoUsuario tipoLogado = usuarioLogado.getTipo();
        for (TipoUsuario t : tipos) {
            if (t == tipoLogado) return true;
        }
        return false;
    }
}
