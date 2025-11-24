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
	public void emprestar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void devolver() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String exibirInformacoes() {
		// TODO Auto-generated method stub
		return null;
	}
}
