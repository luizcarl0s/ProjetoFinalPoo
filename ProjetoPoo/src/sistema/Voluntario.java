package sistema;

public class Voluntario extends Usuario {

    private String perfil;

    public Voluntario(String cpf, String nome, String contato,
                      String user, String senha, String perfil) {

        super(cpf, nome, contato, TipoUsuario.VOLUNTARIO, user, senha);
        this.perfil = perfil;
    }

    public String getPerfil() {
        return perfil;
    }
}
