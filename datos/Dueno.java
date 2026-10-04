package datos;

import java.util.HashSet;
import java.util.Scanner;

public class Dueno {
    private String nombre;
    private long telefono;
    private Direccion direccion;
    private HashSet<Mascota> mascotas;

    public Dueno(String nombre, long telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.mascotas = new HashSet<>();
    }

    public Dueno(String nombre, long telefono, Direccion direcciom) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direcciom;
        this.mascotas = new HashSet<>();
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

    public void setMascotas(HashSet<Mascota> mascotas) {
        this.mascotas = mascotas;
    }
    public HashSet<Mascota> getMascotas() {
        return mascotas;
    }

    public void agregarMascota(Mascota mascota) {
        this.mascotas.add(mascota);;
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

    /*public void elimMascota(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Ingrese le nombre de la mascota que se eliminará: ");
        String nombre=sc.nextLine().trim();
        int band=0;
        do{
            Mascota mascotaEncontrada=getMascota(nombre);

            if (mascotaEncontrada!=null) {
                mascotas.remove(mascotaEncontrada);
                System.out.println("Mascota eliminada, volviendo...");
                return;
            }
            System.out.println("Esa mascota no está registrada, ¿desea intentar con otro nombre?(s/n");
            String opcaux=sc.nextLine().trim();

            if(opcaux.equalsIgnoreCase("s")){
                System.out.println("Ingrese le nombre de la mascota que se eliminará: ");
                nombre=sc.nextLine().trim();
            }else{
                System.out.println("Cancelando eliminación...");
                band=1;
            }
        }while(band!=1);
    }*/

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
