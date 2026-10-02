package registros;

import java.util.HashMap;
import java.util.Map;
import datos.Dueno;

public class ListaDueno {
    private static HashMap<Long, Dueno> duenos = new HashMap<>();

    static {
        Dueno temp = new Dueno("Carlos", 5512345678L);
        duenos.put(temp.getTelfono(), temp);
        temp = new Dueno("Leslie", 5598765432L);
        duenos.put(temp.getTelfono(), temp);
    }

    public static HashMap<Long, Dueno> getDuenos() {
        return duenos;
    }

    public static void agregarDueno(Dueno dueno) {
        duenos.put(dueno.getTelfono(), dueno);
    }

    public static void mostrarDuenos() {
        for (Map.Entry<Long, Dueno> dueno : duenos.entrySet()) {
            System.out.println(dueno.getKey() + " -> " + dueno.getValue().getNombre());
        }
    }
}
