public class Mascota {
    private String nombre;
    private String especie;
    private String raza;
    private byte edad;
    private Dueno dueno;
    private int id;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public void setEdad(byte edad) {
        this.edad = edad;
    }

    public void setDueno(Dueno dueno) {
        this.dueno = dueno;
    }

    public void setId(int id) {
        this.id = id;
    }
}
