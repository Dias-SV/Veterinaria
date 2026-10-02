package datos;

import java.util.HashSet;
import registros.ListaMascota;

public class Dueno {
    private String nombre;
    private long telefono;
    private Direccion direccion;
    private ListaMascota mascota;

    public Dueno(String nombre, long telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.mascota.crearSet();
    }

    public Dueno(String nombre, long telefono, Direccion direcciom) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direcciom;
        this.mascota.crearSet();
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }
    public long getTelfono() {
        return telefono;
    }

    public void setDieccion(Direccion direccion) {
        this.direccion = direccion;
    }
    public Direccion getDireccion() {
        return direccion;
    }

    public void setMascota(ListaMascota mascota) {
        this.mascota = mascota;
    }
    public ListaMascota getMascota() {
        return mascota;
    }

    public void agregarMascota(Mascota mascota) {
        this.mascota.agregarMascota(mascota);;
    }

    public void mostrarDueno() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Telefono: " + telefono);
        System.out.println("Direccion: ");
        direccion.mostrarDomicilio();
    }
}
