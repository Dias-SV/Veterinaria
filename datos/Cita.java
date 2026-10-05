package datos; 
import java.time.LocalDate;
import java.time.LocalTime;
import registros.treeCitas;

public class Cita implements Comparable<Cita>{//implementacion de interfaz necesaria para TreeSet
    private LocalDate fecha;
    private LocalTime hora;
    private String motivo;
    private Mascota mascota;
    private Dueno dueno;
    public Cita(LocalDate fecha, LocalTime hora, String motivo, Dueno dueno, Mascota mascota){
        this.fecha=fecha;
        this.hora=hora;
        this.motivo=motivo;
        this.dueno=dueno;
        this.mascota=mascota;
    }
    public LocalDate getFecha(){
        return fecha;
    }
    public LocalTime getHora(){
        return hora;
    }
    public String getMotivo(){
        return motivo;
    }
    public Dueno getDueno(){
        return dueno;
    }
    public Mascota getMascota(){
        return mascota;
    }
    public void setFecha(LocalDate fecha){
        this.fecha=fecha;
    }
    public void setHora(LocalTime hora){
        this.hora=hora;
    }
    public void setMotivo(String motivo){
        this.motivo=motivo;
    }
    public void setDueno(Dueno dueno){
        this.dueno=dueno;
    }
    public void setMascota(Mascota mascota){
        this.mascota=mascota;
    }
    public void mostrarCita(){
        System.out.println("\nDatos de cita: ");
        System.out.println("Fecha: " + fecha + " | Hora: " + hora);
        System.out.println("Dueño: " + dueno.getNombre() + " (Tel: " + dueno.getTelefono() + ")");
        System.out.println("Mascota: " + mascota.getNombre());
        System.out.println("Motivo: " + motivo);
    }

    @Override //necesario para que el treeSet pueda acomodar con orden las Citas y para poder compilar(se hace como automatico el uso de este compareTo)
    public int compareTo(Cita nueva){
        //el compareTo de aquí como no pertenece a una cita, ocupa el predefinido para las clases y objetos base de Java
        int compFecha = this.fecha.compareTo(nueva.getFecha());//intento acomodar por fecha
        if (compFecha != 0) return compFecha;

        int compHora = this.hora.compareTo(nueva.getHora());//si las fechas son iguales, por hora
        if (compHora != 0) return compHora;

        int compMascota = this.mascota.getNombre().compareTo(nueva.getMascota().getNombre());
        if (compMascota != 0) return compMascota;//si los datos anteriores se repiten, por el nombre de la mascota

        return Long.compare(this.dueno.getTelefono(), nueva.getDueno().getTelefono());//finalmente por la clave única del dueño
    }
}