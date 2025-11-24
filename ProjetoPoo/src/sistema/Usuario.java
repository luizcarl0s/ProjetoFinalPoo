package sistema;

import java.util.List;

public class Usuario {
	private String cpf;
	private String nome;
	private String contato;
	private Historico historico;
	private List<Penalidade> penalidades;
	
	public Usuario(String cpf, String nome, String contato, Historico historico) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.contato = contato;
		this.historico = historico;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public Historico getHistorico() {
		return historico;
	}

	public void setHistorico(Historico historico) {
		this.historico = historico;
	}
	
	public boolean estaSuspenso() {
		return false;
	}
	
	public boolean temMultaPendente() {
		return false;
	}
}
