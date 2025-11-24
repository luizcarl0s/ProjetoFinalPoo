package sistema;

public class Voluntario extends Usuario{
	private String perfil;

	public Voluntario(String cpf, String nome, String contato, Historico historico, String perfil) {
		super(cpf, nome, contato, historico);
		this.perfil = perfil;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
}
