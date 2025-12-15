package sistema;

import java.time.LocalDate;

public class Penalidade {
    private Usuario usuario;
    private String motivo;
    private LocalDate inicio;
    private LocalDate fim;

    public Penalidade(Usuario usuario, String motivo, int dias) {
        this.usuario = usuario;
        this.motivo = motivo;
        this.inicio = LocalDate.now();
        this.fim = inicio.plusDays(dias);
    }

    public Usuario getUsuario() {
        return usuario;
    }
    
    public String getMotivo() {
        return motivo;
    }

    public boolean estaAtiva() {
        return LocalDate.now().isBefore(fim);
    }

    public String exibir() {
        return "Motivo: " + motivo + " | Até: " + fim + " | Ativa: " + (estaAtiva() ? "Sim" : "Não");
    }
}
