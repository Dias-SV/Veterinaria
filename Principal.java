import java.util.HashSet;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Scanner;
import registros.*;
import datos.*;

public class Principal {
    static Scanner entrada = new Scanner(System.in);
    public static void main(String[] args) {
        int opcionM, opcionS;
        HashSet<Dueno> duenos = ListaDueno.getDuenos();
        HashMap<Integer, Mascota> mascotas = ListaMascota.crearMap();

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
            opcionM = entrada.nextInt();
            entrada.nextLine();

            switch (opcion) {
                case 1:
                    if (duenos.isEmpty()) {
                        System.out.println("No hay duenos registrados");
                    } else {
                        registrarCita();
                    }
                    break;

                case 2:
                    if (duenos.isEmpty()) {
                        System.out.println("No hay duenos registrados");
                    } else {
                        registrarMascota();
                    }
                    break;

                case 3:
                    if (duenos.isEmpty() && ms.isEmpty()) {
                        System.out.println("No hay registros");
                    } else {
                        System.out.println();
                        System.out.println("-----Modificador de registros-----\n");
                        System.out.println("1. Modificar dueno");
                        System.out.println("2. Modificar mascota");
                        System.out.println("3. Modificar consulta");
                        System.out.println("0. Salir");
                        opcionS = entrada.nextInt();
                        entrada.nextLine();
                        do {
                            switch (opcionS) {
                                case 1:
                                    if (duenos.isEmpty()) {
                                        System.out.println("No hay duenos registrados");    
                                    } else {
                                        System.out.print("Dueno a modificar: ");
                                        System.out.println("-----Datos di-----\n");
                                        System.out.println("1. Modificar dueno");
                                        System.out.println("2. Modificar mascota");
                                        System.out.println("3. Modificar consulta");
                                        System.out.println("0. Salir");
                                        opcionS = entrada.nextInt();
                                        entrada.nextLine();
                                    }
                                    break;

                                case 2:
                                    break;

                                case 3:
                                    break;

                                case 0:
                                    System.out.println("Cerrando submenu");
                            
                                default:
                                    break;
                            }
                            
                        } while (condition);
                        }
                    break;

                case 4:
                    
            
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

    public static void registrarMascota() {
        System.out.print("Ingrese el nombre: ");
        String nombre = entrada.nextLine();
        System.out.print("Ingrese la especie: ");
        String especie = entrada.nextLine();
        System.out.print("Ingrese la raza: ");
        String raza = entrada.nextLine();
        System.out.print("Ingrese la edad: ");
        byte edad = entrada.nextByte();
        System.out.print("Ingrese el dueno: "); //Tambien esta n
        String nombreD = entrada.nextLine();

        Dueno dueno = ListaDueno.getDueno(nombre);
        while (dueno == null) {
            System.out.println("No hay ningun dueno registrado con ese nombre"); //Y estas dos
            System.out.print("Ingrese el dueno: "); 
            nombre = entrada.nextLine();
            dueno = ListaDueno.getDueno(nombre);
        }
        
        ListaMascota.agregarMascota(new Mascota(nombre, especie, raza, edad, 1));
        System.out.println("Consulta agregada con exito"); 
    }
}
