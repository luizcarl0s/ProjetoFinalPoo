package sistema;

import java.util.List;

public class ServicoComunitario {
	private int id;
	private String nome;
	private String descricao;
	private Usuario responsavel;
	private List<Usuario> participantes;
	private int vagas;
	private String horario;
	
	public ServicoComunitario(int id, String nome, String descricao, Usuario responsavel, List<Usuario> participantes,
			int vagas, String horario) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.responsavel = responsavel;
		this.participantes = participantes;
		this.vagas = vagas;
		this.horario = horario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Usuario getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Usuario responsavel) {
		this.responsavel = responsavel;
	}

	public List<Usuario> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(List<Usuario> participantes) {
		this.participantes = participantes;
	}

	public int getVagas() {
		return vagas;
	}

	public void setVagas(int vagas) {
		this.vagas = vagas;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public int getId() {
		return id;
	}
	
	public boolean adicionarParticipante() {
		return false;
	}
	
	public boolean removerParticipante() {
		return false;
	}
	
	public String listarParticipantes() {
		return "";
	}
}
