package registros;

import java.util.HashMap;
import java.util.Map;

import datos.Direccion;
import datos.Dueno;

public class ListaDueno {
    private static HashMap<Long, Dueno> duenos = new HashMap<>();

    static {
        Direccion dir = new Direccion("Rio de los Pinos",(short)346,"Bosques del Oriente","Gustavo A. Madero","Cdmx",50782);
        Dueno temp = new Dueno("Carlos", 5512345678L, dir);
        duenos.put(temp.getTelfono(), temp);
        dir = new Direccion("Rio de los Remedios",(short)545,"Lomas del Rosario","Azcapotzalco","Cdmx",36425);
        temp = new Dueno("Leslie", 5598765432L, dir);
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
            dueno.getValue().mostrarDueno();
            System.out.println();
        }
    }
}
