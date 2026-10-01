package registros;

import datos.Mascota;
import java.util.HashMap;
import java.util.Map;

public class ListaMascota {
    public static HashMap<Integer, Mascota> crearMap() {
        HashMap<Integer, Mascota> hm = new HashMap<>();
        //Mascota m = new Mascota("Tostada", (byte)5, 1);
        //hm.add(m.getId(), m);
        return hm;
    }

    public static void mostrarMascotas(HashMap<Integer, Mascota> mascotas) {
        for (Map.Entry<Integer, Mascota> m : mascotas.entrySet()) {
            System.out.println(m.getKey() + " -> " + m.getValue());
        }
    }
}
