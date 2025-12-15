package sistema;

import java.util.List;

public class Login {

    private List<Usuario> usuarios;

    public Login(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Usuario autenticar(String usuario, String senha) {
        for (Usuario u : usuarios) {
            if (u.getCredencial() != null &&
                u.getCredencial().autenticar(usuario, senha)) {
                return u;
            }
        }
        return null;
    }
}
