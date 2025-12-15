package sistema;

public class Credencial {
    private String usuario;
    private String senha;

    public Credencial(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }

    public boolean autenticar(String usuario, String senha) {
        return this.usuario.equals(usuario) && this.senha.equals(senha);
    }
}
