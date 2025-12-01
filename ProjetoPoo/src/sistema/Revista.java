package sistema;

public class Revista extends Item{
	private String edicao;
	private String mes;
	
	public Revista(String nome, int codigo, boolean disponivel, String edicao, String mes) {
		super(nome, codigo, disponivel);
		this.edicao = edicao;
		this.mes = mes;
	}

	public String getEdicao() {
		return edicao;
	}

	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	@Override
	public String exibirInformacoes() {
		return "Revista: " + nome +
		"\nEdicao: " + edicao +
		"\nMês: " + mes + 
		"\nDisponível:  " + (disponivel ? "Sim" : "Não");
	}
}
