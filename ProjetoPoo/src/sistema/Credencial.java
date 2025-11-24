package sistema;

public class Credencial {
	private String cpf;
	private String senha;
	
	public Credencial(String cpf, String senha) {
		super();
		this.cpf = cpf;
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public String getSenha() {
		return senha;
	}
}
