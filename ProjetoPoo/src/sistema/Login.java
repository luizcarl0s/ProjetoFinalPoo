package sistema;

import java.util.ArrayList;
import java.util.List;

public class Login {
	private List<Credencial> credenciais;
	private SistemaBiblioteca sistema;
	
	public Login(List<Credencial> credenciais, SistemaBiblioteca sistema) {
		this.credenciais = new ArrayList<>();
		this.sistema = sistema;
	}
	
	public boolean registrarAcesso(String cpf, String senha) {
		for(Credencial c : credenciais) {
			if(c.getCpf().equals(cpf)) {
				return false;
			}
		}
		
		Credencial nc = new Credencial(cpf, senha);
		return this.credenciais.add(nc);
	}
	
	public Usuario autenticarUsuario(String cpf, String senha) {
		for(Credencial c : credenciais) {
			if(c.getCpf().equals(cpf) && c.getSenha().equals(senha)) {
				return this.sistema.buscarUsuarioPorCpf(cpf);
			}
		}
		
		return null;
	}
}
