package sistema;

public abstract class Item implements Emprestavel{
	private String nome;
	private int codigo;
	private boolean disponivel;
	
	public Item(String nome, int codigo, boolean disponivel) {
		this.nome = nome;
		this.codigo = codigo;
		this.disponivel = disponivel;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}
	
	public abstract String exibirInformacoes();
}
