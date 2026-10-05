package datos;

import java.util.ArrayList;
import java.util.Scanner;

public class Dueno {
    private String nombre;
    private long telefono;
    private Direccion direccion;
    private ArrayList<Mascota> mascotas;

    public Dueno(String nombre, long telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.mascotas = new ArrayList<>();
    }

    public Dueno(String nombre, long telefono, Direccion direcciom) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direcciom;
        this.mascotas = new ArrayList<>();
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
    public long getTelefono() {
        return telefono;
    }

    public void setDieccion(Direccion direccion) {
        this.direccion = direccion;
    }
    public Direccion getDireccion() {
        return direccion;
    }

    public void setMascotas(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }
    public ArrayList<Mascota> getMascotas() {
        return mascotas;
    }

    public void agregarMascota(Mascota mascota) {
        this.mascotas.add(mascota);
    }

    public Mascota getMascota(String nombre) { //Para regresar solo una
        for (Mascota mascota : mascotas) {
            if (mascota.getNombre().equals(nombre)) {
                return mascota;
            }
        }
        return null;
    }

    public void mostrarMascotas() {
        for (Mascota mascota : mascotas) {
            mascota.mostrarMascota();
        }
    }

    public void mostrarDueno() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Telefono: " + telefono);
        System.out.println("Direccion: ");
        direccion.mostrarDomicilio();
    }


    public boolean elimMascota(String nombre){
        Mascota mascotaEncontrada=getMascota(nombre);
        if (mascotaEncontrada!=null) {
            mascotas.remove(mascotaEncontrada);
            System.out.println("Mascota eliminada, volviendo...");
            return true;
        }
        return false;
    }
}
