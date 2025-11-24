package sistema;

import java.util.ArrayList;
import java.util.List;

public class SistemaBiblioteca {
	private List<Item> itens;
	private List<Usuario> usuarios;
	private List<Emprestimo> emprestimos;
	private List<ServicoComunitario> servicos;
	
	public SistemaBiblioteca() {
		this.itens = new ArrayList<>();
		this.usuarios = new ArrayList<>();
		this.emprestimos = new ArrayList<>();
		this.servicos = new ArrayList<>();
	}
	
	public void adicionarItem(Item item) {
		this.itens.add(item);
	}
	
	public void cadastrarUsuario(Usuario usuario) {
		this.usuarios.add(usuario);
	}
	
	public boolean registrarEmprestimo(int itemCodigo, String cpfUsuario) {
		return false;
	}
	
	public boolean registrarDevolucao(int itemCodigo, String cpfUsuario) {
		return false;
	}
	
	public String listarItens() {
		return "";
	}
	
	public String listarItensDisponiveis() {
		return "";
	}
	
	public String listarEmprestimos() {
		return "";
	}
	
	public void cadastrarServico(ServicoComunitario servico) {
		this.servicos.add(servico);
	}
	
	public String listarServicos() {
		return "";
	}
	
	public Usuario buscarUsuarioPorCpf(String cpf) {
		return null;
	}
	
	public Item buscarItemPorCodigo(int codigo) {
		return null;
	}
	
	public boolean registrarParticipacaoServico(int idServico, String cpfUsuario) {
		return false;
	}
	
	public Historico consultarHistorico(Usuario usuario) {
		return null;
	}
	
	public void aplicarPenalidade(Penalidade penalidade) {
		
	}
}
