package sistema;

public class Penalidade {
	private int id;
	private String tipo;
	private String dataInicio;
	private String dataFinal;
	private String motivo;
	private Usuario usuarioPenalizado;
	
	public Penalidade(int id, String tipo, String dataInicio, String dataFinal, String motivo,
			Usuario usuarioPenalizado) {
		this.id = id;
		this.tipo = tipo;
		this.dataInicio = dataInicio;
		this.dataFinal = dataFinal;
		this.motivo = motivo;
		this.usuarioPenalizado = usuarioPenalizado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(String dataFinal) {
		this.dataFinal = dataFinal;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public Usuario getUsuarioPenalizado() {
		return usuarioPenalizado;
	}

	public void setUsuarioPenalizado(Usuario usuarioPenalizado) {
		this.usuarioPenalizado = usuarioPenalizado;
	}
	
	public boolean estaAtiva() {
		return false;
	}
}
