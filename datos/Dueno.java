package datos;

import java.util.HashSet;

public class Dueno {
    private String nombre;
    private long telefono;
    private Direccion direccion;
    private HashSet<Mascota> mascota;

    public Dueno(String nombre, long telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
        mascota = new HashSet<>();
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

    public void setMascota(HashSet<Mascota> mascota) {
        this.mascota = mascota;
    }
    public HashSet<Mascota> getMascota() {
        return mascota;
    }

    public void agregarMascota(Mascota mascota) {
        this.mascota.add(mascota);
    }

    public void mostrarDueno() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Telefono: " + telefono);
        System.out.println("Direccion: ");
        direccion.mostrarDomicilio();
    }
}
