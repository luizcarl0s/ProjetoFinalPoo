package sistema;

public class Revista extends Item{
	private String edicao;
	
	public Revista(String nome, int codigo, String edicao) {
		super(nome, codigo);
		this.edicao = edicao;
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
        return "Revista: " + nome + " | Edição: " + edicao;
    }
}
