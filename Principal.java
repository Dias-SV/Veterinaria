import java.util.HashSet;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Scanner;
import registros.*;
import datos.*;

public class Principal {
    static Scanner entrada = new Scanner(System.in);
    public static void main(String[] args) {
        
        int opcion;
        HashSet<Dueno> duenos = ListaDueno.getDuenos();
        HashMap<Integer, Mascota> ms = ListaMascota.crearMap();

        do {
            System.out.println();
            System.out.println("-----Clinica veterinaria-----\n");
            System.out.println("1. Registrar consulta nueva");
            System.out.println("2. Registrar mascota nueva");
            System.out.println("3. Registrar dueno nuevo");
            System.out.println("4. Modificar registros");
            System.out.println("5. Consultar mascotas");
            System.out.println("6. Consultar duenos");
            System.out.println("0. Salir");
            opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion) {
                case 1:
                    ListaDueno.mostrarDuenos();
                    break;

                case 2:
                    ListaMascota.mostrarMascotas();
            
                default:
                    break;
            }
            
        } while (opcion != 0); 
    }
    
    public static void registrarCita() {
        System.out.println("Ingrese la fecha (dd/mm/aaaa)");
        System.out.print("Dia: ");
        int dia = entrada.nextInt();
        System.out.print("Mes: ");
        int mes = entrada.nextInt();
        System.out.print("Ano: "); //Corregir la n
        int ano = entrada.nextInt();
        entrada.nextLine();
        LocalDate fecha = LocalDate.of(ano, mes, dia);
        System.out.print("Ingrese el motivo de consulta: ");
        String motivo = entrada.nextLine();
        System.out.print("Ingrese el diagnostico: ");
        String diagnostico = entrada.nextLine();
        System.out.print("Ingrese el tratamiento: ");
        String tratamiento = entrada.nextLine();
        System.out.print("Ingrese el dueno: "); //Tambien esta n
        String nombre = entrada.nextLine();

        Dueno dueno = ListaDueno.getDueno(nombre);
        while (dueno == null) {
            System.out.println("No hay ningun dueno registrado con ese nombre"); //Y estas dos
            System.out.print("Ingrese el dueno: "); 
            nombre = entrada.nextLine();
            dueno = ListaDueno.getDueno(nombre);
        }
        
        Consulta consulta = new Consulta(fecha, motivo, diagnostico, tratamiento, dueno);
        System.out.println("Consulta agregada con exito"); 
    }
}
