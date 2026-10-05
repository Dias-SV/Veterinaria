package registros;

import java.util.HashMap;
import java.util.Map;

import datos.Direccion;
import datos.Dueno;

public class ListaDueno {
    private static HashMap<Long, Dueno> duenos = new HashMap<>();

    public static HashMap<Long, Dueno> getDuenos() {
        return duenos;
    }

    public static void agregarDueno(Dueno dueno) {
        duenos.put(dueno.getTelfono(), dueno);
    }

    public static void mostrarDuenos() {
        for (Map.Entry<Long, Dueno> dueno : duenos.entrySet()) {
            dueno.getValue().mostrarDueno();
            System.out.println();
        }
    }
}
