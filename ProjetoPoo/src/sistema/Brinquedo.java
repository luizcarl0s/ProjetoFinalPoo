package sistema;

public class Brinquedo extends Item{
	private String material;
	private int faixaEtaria;
	
	public Brinquedo(String nome, int codigo, String material, int faixaEtaria) {
		super(nome, codigo);
		this.material = material;
		this.faixaEtaria = faixaEtaria;
	}

	@Override
    public void emprestar() {
        this.disponivel = false;
    }

    @Override
    public void devolver() {
        this.disponivel = true;
    }

    @Override
    public String exibirInformacoes() {
        return "Brinquedo: " + nome + " | Material: " + material +
               " | Faixa etária: " + faixaEtaria;
    }
}
