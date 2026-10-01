import java.util.HashSet;
import java.util.HashMap;
import java.util.Scanner;
import registros.*;
import datos.*;

public class Principal {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int opcion;        
        HashSet<Dueno> lista = ListaDueno.crearSet();
        HashMap<Integer, Mascota> ms = ListaMascota.crearMap();

        do {
            opcion = entrada.nextInt();
            entrada.nextLine();
            switch (opcion) {
                case 1:
                    ListaDueno.mostrarDuenos(lista);
                    break;

                case 2:
                    ListaMascota.mostrarMascotas(ms);
            
                default:
                    break;
            }
            
        } while (opcion != 0); 
    }
}
