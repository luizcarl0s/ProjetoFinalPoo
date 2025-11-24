package sistema;

public class Gerente extends Usuario{
	private String setorResponsavel;

	public Gerente(String cpf, String nome, String contato, Historico historico, String setorResponsavel) {
		super(cpf, nome, contato, historico);
		this.setorResponsavel = setorResponsavel;
	}

	public String getSetorResponsavel() {
		return setorResponsavel;
	}

	public void setSetorResponsavel(String setorResponsavel) {
		this.setorResponsavel = setorResponsavel;
	}
	
	public boolean cadastrarVoluntario() {
		return false;
	}
}
