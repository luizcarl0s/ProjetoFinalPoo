package sistema;

import java.util.ArrayList;

public class Historico {
    private ArrayList<Emprestimo> emprestimos;
    private ArrayList<ServicoComunitario> servicos;
    private ArrayList<Penalidade> penalidades;

    public Historico() {
        emprestimos = new ArrayList<>();
        servicos = new ArrayList<>();
        penalidades = new ArrayList<>();
    }

    public void adicionarEmprestimo(Emprestimo e) {
        emprestimos.add(e);
    }

    public void adicionarServico(ServicoComunitario s) {
        servicos.add(s);
    }

    public void adicionarPenalidade(Penalidade p) {
        penalidades.add(p);
    }

    public void listarEmprestimos() {
        if (emprestimos.isEmpty()) {
            System.out.println("Nenhum empréstimo registrado.");
            return;
        }

        for (Emprestimo e : emprestimos) {
            System.out.println("- " + e.getItem().getNome() + " | Status: " + e.getStatus());
        }
    }

    public void listarServicos() {
        if (servicos.isEmpty()) {
            System.out.println("Nenhum serviço comunitário registrado.");
            return;
        }

        for (ServicoComunitario s : servicos) {
            System.out.println("- " + s.getNome());
        }
    }

    public void listarPenalidades() {
        if (penalidades.isEmpty()) {
            System.out.println("Nenhuma penalidade registrada.");
            return;
        }

        for (Penalidade p : penalidades) {
            System.out.println("- " + p.getMotivo() + " | Ativa: " + p.estaAtiva());
        }
    }
}
