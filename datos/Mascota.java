package datos;

public class Mascota {
    private String nombre;
    private String especie;
    private String raza;
    private byte edad;

    public Mascota(String nombre, String especie, String raza, byte edad) {
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.edad = edad;
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

    public void mostrarMascota() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Especie: " + especie);
        System.out.println("Raza: " + raza);
        System.out.println("Edad: " + edad);
    }
}
