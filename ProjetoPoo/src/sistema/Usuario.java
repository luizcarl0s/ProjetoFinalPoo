package sistema;

public class Usuario {
    protected String cpf;
    protected String nome;
    protected String contato;
    protected TipoUsuario tipo;
    protected Historico historico;
    private Credencial credencial;

    public Usuario(String cpf, String nome, String contato, TipoUsuario tipo, String usuarioLogin, String senha) {
        this.cpf = cpf;
        this.nome = nome;
        this.contato = contato;
        this.tipo = tipo;
        this.historico = new Historico();
        this.credencial = new Credencial(usuarioLogin, senha);
    }

    public Credencial getCredencial() {
        return credencial;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public TipoUsuario getTipo() {
        return tipo;
    }

    public Historico getHistorico() {
        return historico;
    }
}
