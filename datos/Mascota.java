package datos;

public class Mascota {
    private String nombre;
    private String especie;
    private String raza;
    private byte edad;
    private Dueno dueno;
    private int id;

    public Mascota(String nombre, String especie, String raza, byte edad, int id) {
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.edad = edad;
        this.id = id;
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

    public void setDueno(Dueno dueno) {
        this.dueno = dueno;
    }
    public Dueno getDueno() {
        return dueno;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
}
