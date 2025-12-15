package sistema;

public class Gerente extends Usuario {

    private String setorResponsavel;

    public Gerente(String cpf, String nome, String contato,
                   String user, String senha, String setorResponsavel) {

        super(cpf, nome, contato, TipoUsuario.GERENTE, user, senha);
        this.setorResponsavel = setorResponsavel;
    }

    public String getSetorResponsavel() {
        return setorResponsavel;
    }

    public void gerarRelatorio() {
        System.out.println("Relatório gerado pelo gerente: " + nome);
    }
}
