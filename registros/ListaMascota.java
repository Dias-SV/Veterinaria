package registros;

import datos.Mascota;
import java.util.HashMap;
import java.util.Map;

public class ListaMascota {
    public static HashMap<Integer, Mascota> mascotas = new HashMap<>();
    public static HashMap<Integer, Mascota> crearMap() {
        //Mascota m = new Mascota("Tostada", (byte)5, 1);
        //hm.add(m.getId(), m);
        return mascotas;
    }

    public static void mostrarMascotas() {
        for (Map.Entry<Integer, Mascota> mascota : mascotas.entrySet()) {
            System.out.println(mascota.getKey() + " -> " + mascota.getValue());
        }
    }
}
