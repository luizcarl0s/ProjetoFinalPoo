package sistema;

public abstract class Item implements Emprestavel{
	protected String nome;
	protected int codigo;
	protected boolean disponivel;
	
	public Item(String nome, int codigo, boolean disponivel) {
		this.nome = nome;
		this.codigo = codigo;
		this.disponivel = disponivel;
	}

	public String getNome() {
		return nome;
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

	@Override
	public void emprestar() {
		if (!disponivel) {
			System.out.println("O item já está emprestado!");
			return;
		}
		disponivel = false;
	}

	@Override
	public void devolver() {
		disponivel = true;
	}
}
