package registros;

import java.util.HashSet;
import datos.Dueno;

public class ListaDueno {
    public static HashSet<Dueno> crearSet() {
        HashSet<Dueno> hs = new HashSet<>();
        hs.add(new Dueno("Carlos", 5512345678L, 1));
        hs.add(new Dueno("Leslie", 5598765432L, 2));
        return hs;
    }

    public static void mostrarDuenos(HashSet<Dueno> duenos) {
        for (Dueno dueno : duenos) {
            System.out.println(dueno.getNombre());
        }
    }
}
