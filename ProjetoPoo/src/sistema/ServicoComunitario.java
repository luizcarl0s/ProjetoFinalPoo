package sistema;

import java.util.ArrayList;

public class ServicoComunitario {

    private int id;
    private String nome;
    private String descricao;
    private Usuario responsavel;
    private int vagas;
    private String horario;
    private ArrayList<Usuario> inscritos;

    public ServicoComunitario(int id, String nome, String descricao,
                              Usuario responsavel, int vagas, String horario) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.responsavel = responsavel;
        this.vagas = vagas;
        this.horario = horario;
        this.inscritos = new ArrayList<>();
    }

    // ================= GETTERS =================

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Usuario getResponsavel() {
        return responsavel;
    }

    // ================= REGRAS DE NEGÓCIO =================

    // ✔ Verifica se ainda há vaga
    public boolean temVaga() {
        return inscritos.size() < vagas;
    }

    // ✔ Verifica se o usuário já está inscrito
    public boolean estaInscrito(Usuario u) {
        return inscritos.contains(u);
    }

    // ✔ Inscreve o usuário
    public void inscrever(Usuario u) {
        if (!estaInscrito(u) && temVaga()) {
            inscritos.add(u);
        }
    }

    // (Opcional, mas útil)
    public ArrayList<Usuario> getInscritos() {
        return inscritos;
    }

    public String resumo() {
        return "ID: " + id +
               " | Nome: " + nome +
               " | Responsável: " + responsavel.getNome() +
               " | Vagas restantes: " + (vagas - inscritos.size()) +
               " | Horário: " + horario;
    }

	public String getDescricao() {
		return descricao;
	}

}
