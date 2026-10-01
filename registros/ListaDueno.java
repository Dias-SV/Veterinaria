package registros;

import java.util.HashSet;
import datos.Dueno;

public class ListaDueno {
    private static HashSet<Dueno> duenos = new HashSet<>();

    static {
        duenos.add(new Dueno("Carlos", 5512345678L, 1));
        duenos.add(new Dueno("Leslie", 5598765432L, 2));
    }

    public static HashSet<Dueno> getDuenos() {
        return duenos;
    }

    public static void agregarDueno(Dueno dueno) {
        duenos.add(dueno);
    }

    public static Dueno getDueno(String nombre) {
        for (Dueno dueno : duenos) {
            if (dueno.getNombre().equalsIgnoreCase(nombre)) {
                return dueno;
            }
        }
        return null;
    }

    public static void mostrarDuenos() {
        for (Dueno dueno : duenos) {
            dueno.mostrarDueno();
        }
    }
}
