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
	
	//Métodos de itens;
	
	public boolean adicionarBrinquedo(String nome, int codigo, boolean disponivel, String material, int faixaEtaria) {
		Item novoBriquendo = new Brinquedo(nome, codigo, disponivel, material, faixaEtaria);
		return this.itens.add(novoBriquendo);
	}
	
	public boolean adicionarLivro(String nome, int codigo, boolean disponivel, String autor, String dataLancamento, String isbn) {
		Item novoLivro = new Livro(nome, codigo, disponivel, autor, dataLancamento, isbn);
		return this.itens.add(novoLivro);
	}
	
	public boolean adicionarRevista(String nome, int codigo, boolean disponivel, String edicao, String mes) {
		Item novaRevista = new Revista(nome, codigo, disponivel, edicao, mes);
		return this.itens.add(novaRevista);
	}
	
	public void cadastrarUsuario(Usuario usuario) {
		this.usuarios.add(usuario);
	}
	
	public String listarItens() {
		return "";
	}
	
	public String listarItensDisponiveis() {
		return "";
	}
	
	public boolean registrarEmprestimo(int itemCodigo, String cpfUsuario) {
		return false;
	}
	
	public boolean registrarDevolucao(int itemCodigo, String cpfUsuario) {
		return false;
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
