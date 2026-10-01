package datos;

import java.time.LocalDate;


public class Consulta {
    private LocalDate fecha;
    private String motivo;
    private String diagnostico;
    private String tratamiento;
    private Dueno dueno;

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    public LocalDate getFecha() {
        return fecha;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
    public String getMotivo() {
        return motivo;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }
    public String getDiagnostico() {
        return diagnostico;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }
    public String getTratamiento() {
        return tratamiento;
    }

    public void setDueno(Dueno dueno) {
        this.dueno = dueno;
    }
    public Dueno getDueno() {
        return dueno;
    }
}
