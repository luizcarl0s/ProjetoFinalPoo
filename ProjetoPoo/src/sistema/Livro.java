package sistema;

public class Livro extends Item{
	private String autor;
	private String dataLancamento;
	private String isbn;

	public Livro(String nome, int codigo, String autor, String isbn) {
		super(nome, codigo);
		this.autor = autor;
		this.isbn = isbn;
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
        return "Livro: " + nome + " | Autor: " + autor + " | ISBN: " + isbn;
    }

	public String getDataLancamento() {
		return dataLancamento;
	}
}
