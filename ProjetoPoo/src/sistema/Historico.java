package sistema;

import java.util.List;

public class Historico {
	private List<Emprestimo> emprestimos;
	private List<ServicoComunitario> servicos;
	
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
}
