package sistema;

import java.time.LocalDate;

public class Emprestimo {
    private Item item;
    private Usuario usuario;
    private LocalDate dataSaida;
    private LocalDate dataDevolucaoPrevista;
    private LocalDate dataDevolucaoReal;
    private StatusEmprestimo status;

    public Emprestimo(Item item, Usuario usuario, LocalDate dataSaida, LocalDate dataDevolucaoPrevista) {
        this.item = item;
        this.usuario = usuario;
        this.dataSaida = dataSaida;
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
        this.status = StatusEmprestimo.PENDENTE;
    }

    public Item getItem() {
        return item;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public StatusEmprestimo getStatus() {
        return status;
    }

    public boolean estaPendente() {
        return status == StatusEmprestimo.PENDENTE;
    }

    public void registrar() {
        item.emprestar();
    }

    public void devolver(LocalDate dataDevolucaoReal) {
        this.dataDevolucaoReal = dataDevolucaoReal;

        if (dataDevolucaoReal.isAfter(dataDevolucaoPrevista)) {
            status = StatusEmprestimo.ATRASADO;
        } else {
            status = StatusEmprestimo.DEVOLVIDO;
        }

        item.devolver();
    }

	public LocalDate getDataSaida() {
		return dataSaida;
	}

	public LocalDate getDataDevolucaoReal() {
		return dataDevolucaoReal;
	}
}
