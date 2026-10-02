package registros;

import datos.Mascota;
import java.util.HashSet;

public class ListaMascota {
    private HashSet<Mascota> mascotas;

    public void crearMap() {
        this.mascotas = new HashSet<>();
    }

    public HashSet<Mascota> getMascotas() {
        return mascotas;
    }

    public void agregarMascota(Mascota mascota) {
        mascotas.add(mascota);
    }

    public void mostrarMascotas() {
        for (Mascota mascota : mascotas) {
            mascota.mostrarMascota();
        }
    }
}
