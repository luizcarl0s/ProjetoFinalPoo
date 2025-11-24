package sistema;

public class Livro extends Item{
	private String autor;
	private String dataLancamento;
	private String isbn;

	public Livro(String nome, int codigo, boolean disponivel, String autor, String dataLancamento, String isbn) {
		super(nome, codigo, disponivel);
		this.autor = autor;
		this.dataLancamento = dataLancamento;
		this.isbn = isbn;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(String dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
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
