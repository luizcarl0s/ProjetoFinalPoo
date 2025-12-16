package sistema;

import java.util.Scanner;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
    	
        Scanner sc = new Scanner(System.in);
        SistemaBiblioteca sistema = new SistemaBiblioteca();

        int opcao;

        do {

            System.out.println("Biblioteca Comunitária\n");

            if (sistema.isAutenticado()) {
                System.out.println("Logado como: " + sistema.getUsuarioLogado().getNome() + " (" + sistema.getUsuarioLogado().getTipo() + ")");
            } else {
                System.out.println("Não autenticado\n");
            }

            System.out.println("1 - Cadastrar usuário");
            System.out.println("2 - Cadastrar item");
            System.out.println("3 - Emprestar item");
            System.out.println("4 - Devolver item");
            System.out.println("5 - Criar serviço comunitário");
            System.out.println("6 - Login");
            System.out.println("7 - Logout");
            System.out.println("8 - Gerar relatório");
            System.out.println("9 - Listar serviços comunitários");
            System.out.println("10 - Inscrever-se em serviço comunitário");
            System.out.println("11 - Ver minhas penalidades");
            System.out.println("12 - Aplicar penalidade (Gerente)");
            System.out.println("13 - Ver meu histórico");
            System.out.println("0 - Sair");
            System.out.print("\nOpção: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> cadastrarUsuario(sc, sistema);
                case 2 -> {
                    if (!sistema.temPermissao(TipoUsuario.GERENTE, TipoUsuario.VOLUNTARIO)) {
                        System.out.println("Acesso negado.");
                    } else {
                        cadastrarItem(sc, sistema);
                    }
                }

                case 3 -> {
                    if (!sistema.isAutenticado()) {
                        System.out.println("Faça login primeiro.");
                    } else {
                        emprestarItem(sc, sistema);
                    }
                }

                case 4 -> devolverItem(sc, sistema);
                case 5 -> {
                    if (!sistema.temPermissao(TipoUsuario.GERENTE)) {
                        System.out.println("Acesso negado. Apenas o GERENTE.");
                    } else {
                        criarServico(sc, sistema);
                    }
                }
                case 6 -> login(sc, sistema);
                case 7 -> logout(sistema);
                case 8 -> {
                    if (!sistema.temPermissao(TipoUsuario.GERENTE)) {
                        System.out.println("Acesso negado. Apenas o GERENTE pode gerar relatório.");
                    } else {
                        gerarRelatorio(sistema);
                    }
                }
                case 9 -> sistema.listarServicos();
                case 10 -> inscreverServico(sc, sistema);
                case 11 -> verMinhasPenalidades(sistema);
                case 12 -> aplicarPenalidade(sc, sistema);
                case 13 -> verHistorico(sistema);
                case 0 -> System.out.println("Encerrando sistema...");
                default -> System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        sc.close();
    }

    private static void cadastrarUsuario(Scanner sc, SistemaBiblioteca sistema) {

        System.out.print("CPF: ");
        String cpf = sc.nextLine();

        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Contato: ");
        String contato = sc.nextLine();

        System.out.print("Tipo (GERENTE / VOLUNTARIO / COMUM): ");
        TipoUsuario tipo = TipoUsuario.valueOf(sc.nextLine().toUpperCase());

        System.out.print("Usuário (login): ");
        String user = sc.nextLine();

        System.out.print("Senha: ");
        String senha = sc.nextLine();

        Usuario usuarioNovo;

        switch (tipo) {
            case GERENTE -> {
                System.out.print("Setor responsável: ");
                String setor = sc.nextLine();
                usuarioNovo = new Gerente(cpf, nome, contato, user, senha, setor);
            }
            case VOLUNTARIO -> {
                System.out.print("Perfil do voluntário: ");
                String perfil = sc.nextLine();
                usuarioNovo = new Voluntario(cpf, nome, contato, user, senha, perfil);
            }
            default -> {
            	usuarioNovo = new Usuario(cpf, nome, contato, tipo, user, senha);
            }
        }

        sistema.cadastrarUsuario(usuarioNovo);
        System.out.println("Usuário cadastrado com sucesso!");
    }

    private static void cadastrarItem(Scanner sc, SistemaBiblioteca sistema) {

        if (!sistema.isGerente()) {
            System.out.println("Acesso negado: apenas GERENTE pode cadastrar itens.");
            return;
        }

        System.out.println("1 - Livro | 2 - Revista | 3 - Brinquedo");
        int tipo = sc.nextInt();
        sc.nextLine();

        System.out.print("Código: ");
        int codigo = sc.nextInt();
        sc.nextLine();

        System.out.print("Nome: ");
        String nome = sc.nextLine();

        Item item = null;

        if (tipo == 1) {
            System.out.print("Autor: ");
            String autor = sc.nextLine();
            System.out.print("ISBN: ");
            String isbn = sc.nextLine();
            item = new Livro(nome, codigo, autor, isbn);

        } else if (tipo == 2) {
            System.out.print("Edição: ");
            String edicao = sc.nextLine();
            item = new Revista(nome, codigo, edicao);

        } else if (tipo == 3) {
            System.out.print("Material: ");
            String material = sc.nextLine();
            System.out.print("Faixa etária: ");
            int faixa = sc.nextInt();
            item = new Brinquedo(nome, codigo, material, faixa);
        }

        if (item == null) {
            System.out.println("Tipo de item inválido.");
            return;
        }

        sistema.adicionarItem(item);
        System.out.println("Item cadastrado!");

    }

    private static void emprestarItem(Scanner sc, SistemaBiblioteca sistema) {

        if (sistema.getUsuarioLogado() == null) {
            System.out.println("Faça login antes de realizar empréstimos.");
            return;
        }

        System.out.print("Código do item: ");
        int codigo = sc.nextInt();
        sc.nextLine();

        System.out.print("CPF do usuário: ");
        String cpf = sc.nextLine();

        System.out.print("Data saída (AAAA-MM-DD): ");
        LocalDate saida = LocalDate.parse(sc.nextLine());

        System.out.print("Data devolução (AAAA-MM-DD): ");
        LocalDate devolucao = LocalDate.parse(sc.nextLine());

        sistema.emprestarItem(codigo, cpf, saida, devolucao);
    }

    private static void devolverItem(Scanner sc, SistemaBiblioteca sistema) {

        if (sistema.getUsuarioLogado() == null) {
            System.out.println("Faça login antes de devolver itens.");
            return;
        }

        System.out.print("Código do item: ");
        int codigo = sc.nextInt();

        sistema.devolverItem(codigo);
    }
        
    private static void verMinhasPenalidades(SistemaBiblioteca sistema) {

        if (!sistema.isAutenticado()) {
            System.out.println("Você precisa estar logado.");
            return;
        }

        Usuario u = sistema.getUsuarioLogado();
        sistema.listarPenalidadesDoUsuario(u);
    }

    private static void aplicarPenalidade(Scanner sc, SistemaBiblioteca sistema) {

        if (!sistema.isAutenticado()) {
            System.out.println("Você precisa estar logado.");
            return;
        }

        Usuario logado = sistema.getUsuarioLogado();

        if (logado.getTipo() != TipoUsuario.GERENTE) {
            System.out.println("Apenas gerentes podem aplicar penalidades.");
            return;
        }

        System.out.print("CPF do usuário penalizado: ");
        String cpf = sc.nextLine();

        Usuario u = sistema.buscarUsuarioPorCpf(cpf);

        if (u == null) {
            System.out.println("Usuário não encontrado.");
            return;
        }

        System.out.print("Motivo da penalidade: ");
        String motivo = sc.nextLine();

        System.out.print("Duração (em dias): ");
        int dias = sc.nextInt();
        sc.nextLine();

        sistema.aplicarPenalidade(u, motivo, dias);
        System.out.println("Penalidade aplicada com sucesso.");
    }

    private static void criarServico(Scanner sc, SistemaBiblioteca sistema) {

    	if (!sistema.isAutenticado()) {
            System.out.println("Você precisa estar logado.");
            return;
        }

        Usuario logado = sistema.getUsuarioLogado();

        if (logado.getTipo() != TipoUsuario.GERENTE) {
            System.out.println("Apenas GERENTES podem criar serviços comunitários.");
            return;
        }

        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Descrição: ");
        String desc = sc.nextLine();

        System.out.print("Vagas: ");
        int vagas = sc.nextInt();
        sc.nextLine();

        System.out.print("Horário: ");
        String horario = sc.nextLine();

        ServicoComunitario s = new ServicoComunitario(id, nome, desc, logado, vagas, horario);

        sistema.adicionarServico(s);
        System.out.println("Serviço comunitário criado com sucesso!");
    }

    private static void login(Scanner sc, SistemaBiblioteca sistema) {

        if (sistema.isAutenticado()) {
            System.out.println("Já existe um usuário logado: " + sistema.getUsuarioLogado().getNome());
            return;
        }

        System.out.print("Usuário: ");
        String user = sc.nextLine();

        System.out.print("Senha: ");
        String senha = sc.nextLine();

        if (sistema.login(user, senha)) {
            Usuario u = sistema.getUsuarioLogado();
            System.out.println("Login realizado com sucesso!");
            System.out.println("Bem-vindo, " + u.getNome()
                    + " (" + u.getTipo() + ")");
        } else {
            System.out.println("Usuário ou senha inválidos.");
        }
    }

    private static void logout(SistemaBiblioteca sistema) {

        if (!sistema.isAutenticado()) {
            System.out.println("Nenhum usuário está logado.");
            return;
        }

        System.out.println("Logout realizado: " + sistema.getUsuarioLogado().getNome());

        sistema.logout();
    }
    
    private static void inscreverServico(Scanner sc, SistemaBiblioteca sistema) {

        if (!sistema.isAutenticado()) {
            System.out.println("Você precisa estar logado.");
            return;
        }

        System.out.print("ID do serviço: ");
        int id = sc.nextInt();
        sc.nextLine();

        sistema.inscreverEmServico(id);
    }

    private static void gerarRelatorio(SistemaBiblioteca sistema) {

        System.out.println("\nRelatório do sistema:\n");
        System.out.println("Usuários cadastrados: " + sistema.getTotalUsuarios());
        System.out.println("Itens cadastrados: " + sistema.getTotalItens());
        System.out.println("Itens disponíveis: " + sistema.getItensDisponiveis());
        System.out.println("Itens emprestados: " + sistema.getItensEmprestados());
        System.out.println("Empréstimos ativos: " + sistema.getEmprestimosAtivos());
        System.out.println("Serviços comunitários: " + sistema.getTotalServicos());
        System.out.println("Penalidades ativas: " + sistema.getPenalidadesAtivas());
        System.out.println("\n");
    }
    
    private static void verHistorico(SistemaBiblioteca sistema) {

        if (!sistema.isAutenticado()) {
            System.out.println("Você precisa estar logado.");
            return;
        }

        Usuario u = sistema.getUsuarioLogado();

        System.out.println("\nHistórico de " + u.getNome());

        System.out.println("\nEmpréstimos:");
        u.getHistorico().listarEmprestimos();

        System.out.println("\nServiços comunitários:");
        u.getHistorico().listarServicos();

        System.out.println("\nPenalidades:");
        u.getHistorico().listarPenalidades();
    }
}
