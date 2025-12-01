package sistema;

public class Main {

	public static void main(String[] args) {
		SistemaBiblioteca novoSB = new SistemaBiblioteca();
		
		novoSB.adicionarBrinquedo("Ursinho poo", 1230, false, "Pelúcia", 2);
		novoSB.adicionarLivro("Metamorfose", 987430, false, "Kafka", "1923", "3214158");
		novoSB.listarItensDisponiveis();
	}

}
