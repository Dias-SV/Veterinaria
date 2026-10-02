package datos;

import java.time.LocalDate;


public class Consulta {
    private LocalDate fecha;
    private String motivo;
    private String diagnostico;
    private String tratamiento;

    public Consulta(LocalDate fecha, String motivo, String diagnostico, String tratamiento) {
        this.fecha = fecha;
        this.motivo = motivo;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
    }

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

    public void mostrarConsulta() {
        System.out.println("Fecha: " + fecha);
        System.out.println("Motivo: " + motivo);
        System.out.println("Diagnostico: " + diagnostico);
        System.out.println("Tratamiento: " + tratamiento);
    }
}
