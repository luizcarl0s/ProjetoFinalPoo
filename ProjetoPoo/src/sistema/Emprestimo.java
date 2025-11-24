package sistema;

public class Emprestimo {
	private Item item;
	private Usuario usuario;
	private String dataSaida;
	private String ataDevolucao;
	private double valorMultaPorDia;
	
	public Emprestimo(Item item, Usuario usuario, String dataSaida, String ataDevolucao, double valorMultaPorDia) {
		this.item = item;
		this.usuario = usuario;
		this.dataSaida = dataSaida;
		this.ataDevolucao = ataDevolucao;
		this.valorMultaPorDia = valorMultaPorDia;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(String dataSaida) {
		this.dataSaida = dataSaida;
	}

	public String getAtaDevolucao() {
		return ataDevolucao;
	}

	public void setAtaDevolucao(String ataDevolucao) {
		this.ataDevolucao = ataDevolucao;
	}

	public double getValorMultaPorDia() {
		return valorMultaPorDia;
	}

	public void setValorMultaPorDia(double valorMultaPorDia) {
		this.valorMultaPorDia = valorMultaPorDia;
	}
	
	public void registrar() {
		
	}
	
	public boolean estaPendente() {
		return false;
	}
	
	public int calcularMulta() {
		return 0;
	}
}
