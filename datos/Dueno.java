package datos;

import java.util.HashMap;

public class Dueno {
    private String nombre;
    private long telefono;
    private Direccion direccion;
    private HashMap<Integer, Mascota> mascota;
    private int id;

    public Dueno(String nombre, long telefono, int id) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.id = id;
        mascota = new HashMap<>();
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

    public void setMascota(HashMap<Integer, Mascota> mascota) {
        this.mascota = mascota;
    }
    public HashMap<Integer, Mascota> getMascota() {
        return mascota;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void mostrarDueno() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Telefono: " + telefono);
        System.out.println("Direccion: ");
        direccion.mostrarDomicilio();
        System.out.println("ID: " + id);
    }
}
