package sistema;

public class Brinquedo extends Item{
	private String material;
	private int faixaEtaria;
	
	public Brinquedo(String nome, int codigo, boolean disponivel, String material, int faixaEtaria) {
		super(nome, codigo, disponivel);
		this.material = material;
		this.faixaEtaria = faixaEtaria;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public int getFaixaEtaria() {
		return faixaEtaria;
	}

	public void setFaixaEtaria(int faixaEtaria) {
		this.faixaEtaria = faixaEtaria;
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
