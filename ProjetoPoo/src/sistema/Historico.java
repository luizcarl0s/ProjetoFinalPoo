package sistema;

import java.util.List;

public class Historico {
	private List<Emprestimo> emprestimos;
	private List<ServicoComunitario> servicos;
	private List<Penalidade> penalidades;
	
	public List<Emprestimo> getEmprestimos() {
		return emprestimos;
	}
	public void setEmprestimos(List<Emprestimo> emprestimos) {
		this.emprestimos = emprestimos;
	}
	public List<ServicoComunitario> getServicos() {
		return servicos;
	}
	public void setServicos(List<ServicoComunitario> servicos) {
		this.servicos = servicos;
	}
	public List<Penalidade> getPenalidades() {
		return penalidades;
	}
	public void setPenalidades(List<Penalidade> penalidades) {
		this.penalidades = penalidades;
	}
	
	public void adicionarEmprestimo(Emprestimo e) {
		
	}
	
	public void adicionarServico(ServicoComunitario sc) {
		
	}
	
	public void adicionarPenalidade(Penalidade p) {
		
	}
	
	public String exibirHistorico() {
		return "";
	}
}
