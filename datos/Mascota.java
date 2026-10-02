package datos;

import java.util.ArrayList;

public class Mascota {
    private String nombre;
    private String especie;
    private String raza;
    private byte edad;
    private ArrayList<Consulta> consulta;

    public Mascota(String nombre, String especie, String raza, byte edad) {
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.edad = edad;
        consulta = new ArrayList<>();
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }
    public String getEspecie() {
        return especie;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }
    public String getRaza() {
        return raza;
    }

    public void setEdad(byte edad) {
        this.edad = edad;
    }
    public byte getEdad() {
        return edad;
    }

    public void setConsultas(ArrayList<Consulta> consulta) {
        this.consulta = consulta;
    }
    public ArrayList<Consulta> getConsultas() {
        return consulta;
    }

    public void agregarConsulta(Consulta consulta) {
        this.consulta.add(consulta);
    }

    public void mostrarMascota() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Especie: " + especie);
        System.out.println("Raza: " + raza);
        System.out.println("Edad: " + edad);
    }
}
