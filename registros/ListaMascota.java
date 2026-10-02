package registros;

import datos.Mascota;
import java.util.HashSet;

public class ListaMascota {
    private HashSet<Mascota> mascotas;

    public void crearSet() {
        this.mascotas = new HashSet<>();
    }

    public HashSet<Mascota> getMascotas() {
        return mascotas;
    }

    public void agregarMascota(Mascota mascota) {
        this.mascotas.add(mascota);
    }

    public Mascota getMascota(String nombre) {
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
}
