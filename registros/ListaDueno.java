package registros;

import java.util.HashMap;
import java.util.Map;

import datos.Dueno;

public class ListaDueno {
    private static HashMap<Long, Dueno> duenos = new HashMap<>();

    public static HashMap<Long, Dueno> getDuenos() {
        return duenos;
    }

    public static void agregarDueno(Dueno dueno) {
        duenos.put(dueno.getTelefono(), dueno);
    }

    public static void mostrarDuenos() {
        for (Map.Entry<Long, Dueno> dueno : duenos.entrySet()) {
            dueno.getValue().mostrarDueno();
            System.out.println();
        }
    }

    public static boolean cambiarTelefono(Dueno dueno, long nuevoTelefono) {
        if (existeTelefono(nuevoTelefono)) {
            return false;
        }
        duenos.remove(dueno.getTelefono());
        dueno.setTelefono(nuevoTelefono);
        duenos.put(nuevoTelefono, dueno);
        return true;
    }

    public static boolean existeTelefono(long telefono) {
    return duenos.containsKey(telefono);
}
}
