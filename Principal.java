import java.util.HashSet;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Scanner;
import registros.*;
import datos.*;

public class Principal {
    static Scanner entrada = new Scanner(System.in);
    static HashMap<Long, Dueno> duenos = ListaDueno.getDuenos();
    public static void main(String[] args) {
        int opcionM, opcionS;
        
        do {
            System.out.println();
            System.out.println("-----Clinica veterinaria-----");
            System.out.println("1. Registrar consulta nueva");
            System.out.println("2. Registrar mascota nueva");
            System.out.println("3. Registrar dueño nuevo");
            System.out.println("4. Modificar registros");
            System.out.println("5. Consultar mascotas");
            System.out.println("6. Consultar duenos");
            System.out.println("0. Salir");
            opcionM = entrada.nextInt();
            entrada.nextLine();

            switch (opcionM) {
                case 1:
                    if (duenos.isEmpty()) {
                        System.out.println("No hay dueños registrados");
                    } else {
                        registrarConsulta();
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
                    registrarDueno();
                    break;

                case 4:
                    if (duenos.isEmpty()) {
                        System.out.println("No hay registros");
                    } else {
                        System.out.println();
                        System.out.println("-----Modificador de registros-----");
                        System.out.println("1. Modificar dueño");
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
                                        System.out.print("Numero de telefono de dueño: ");
                                        long telefono = entrada.nextLong();
                                        Dueno dueno = duenos.get(telefono);
                                        while (dueno == null) {
                                            System.out.println("No hay ningun dueño registrado con ese nombre");
                                            System.out.print("Ingrese el numero de telefono del dueño: ");
                                            telefono = entrada.nextLong();
                                            dueno = duenos.get(telefono);
                                        }
                                        System.out.println("\n-----Datos-----");
                                        System.out.println("1. Modificar nombre");
                                        System.out.println("2. Modificar telefono");
                                        System.out.println("3. Modificar direccion");
                                        System.out.println("4. Modificar mascotas");
                                        System.out.println("0. Salir");
                                        opcionS = entrada.nextInt();
                                        entrada.nextLine();
                                        do {
                                            switch (opcionS) {
                                                case 1:
                                                    System.out.println("Inserte el nuevo nombre: ");
                                                    String nombre = entrada.nextLine();
                                                    dueno.setNombre(nombre);
                                                    System.out.println("Nombre modificado correctamente");
                                                    break;
                                            
                                                case 2:
                                                    System.out.println("Inserte el nuevo telefono: ");
                                                    long numero = entrada.nextLong();
                                                    dueno.setTelefono(numero);;
                                                    System.out.println("Telefono modificado correctamente");
                                                    break;

                                                case 3:
                                                    modificarDireccion(dueno.getDireccion());
                                                    break;

                                                case 4:
                                                    break;

                                                case 0:
                                                    System.out.println("Saliendo del submenu");
                                                    break;

                                                default:
                                                    break;
                                            }
                                            
                                        } while (opcionS != 0);
                                    }
                                    break;

                                case 2:
                                    if (duenos.isEmpty()) {
                                        System.out.println("No hay duenos registrados");    
                                    } else {
                                        System.out.print("Numero de telefono de dueño: ");
                                        long telefono = entrada.nextLong();
                                        Dueno dueno = duenos.get(telefono);
                                        while (dueno == null) {
                                            System.out.println("No hay ningun dueño registrado con ese nombre");
                                            System.out.print("Ingrese el numero de telefono del dueño: ");
                                            telefono = entrada.nextLong();
                                            dueno = duenos.get(telefono);
                                        }
                                    }
                                    break;

                                case 3:
                                    if (duenos.isEmpty()) {
                                        System.out.println("No hay duenos registrados");    
                                    } else {
                                        System.out.print("Numero de telefono de dueño: ");
                                        long telefono = entrada.nextLong();
                                        Dueno dueno = duenos.get(telefono);
                                        while (dueno == null) {
                                            System.out.println("No hay ningun dueño registrado con ese nombre");
                                            System.out.print("Ingrese el numero de telefono del dueño: ");
                                            telefono = entrada.nextLong();
                                            dueno = duenos.get(telefono);
                                        }
                                    }
                                    break;

                                case 0:
                                    System.out.println("Cerrando submenu");
                            
                                default:
                                    break;
                            }
                            
                        } while (opcionS != 0);
                        }
                    break;

                case 5:
                    if (duenos.isEmpty()) {
                        System.out.println("No hay duenos registrados");    
                    } else {
                        System.out.print("Numero de telefono de dueño: ");
                        long telefono = entrada.nextLong();
                        Dueno dueno = duenos.get(telefono);
                        while (dueno == null) {
                            System.out.println("No hay ningun dueño registrado con ese nombre");
                            System.out.print("Ingrese el numero de telefono del dueño: ");
                            telefono = entrada.nextLong();
                            dueno = duenos.get(telefono);
                        }
                    }
                    break;
            
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
            
        } while (opcionM != 0); 
    }
    
    public static void registrarConsulta() {
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
        
        System.out.print("Ingrese el numero de telefono del dueño: ");
        long telefono = entrada.nextLong();
        Dueno dueno = duenos.get(telefono);
        while (dueno == null) {
            System.out.println("No hay ningun dueño registrado con ese nombre");
            System.out.print("Ingrese el numero de telefono del dueño: ");
            telefono = entrada.nextLong();
            dueno = duenos.get(telefono);
        }
        
        System.out.print("Ingrese el nombre del paciente: ");
        String nombre = entrada.nextLine();
        Mascota mascota = (dueno.getMascota()).getMascota(nombre);
        while (dueno == null) {
            System.out.println("No hay ningun dueño registrado con ese nombre");
            System.out.print("Ingrese el numero de telefono del dueño: ");
            telefono = entrada.nextLong();
            dueno = duenos.get(telefono);
        }

        mascota.agregarConsulta(new Consulta(fecha, motivo, diagnostico, tratamiento));
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
        System.out.print("Ingrese el numero de telefono del dueño: ");
        long telefono = entrada.nextLong();

        Dueno dueno = duenos.get(telefono);
        while (dueno == null) {
            System.out.println("No hay ningun dueño registrado con ese nombre");
            System.out.print("Ingrese el numero de telefono del dueño: ");
            telefono = entrada.nextLong();
            dueno = duenos.get(telefono);
        }
        
        dueno.agregarMascota(new Mascota(nombre, especie, raza, edad));
        System.out.println("Mascota agregada con exito"); 
    }

    public static void registrarDueno() {
        System.out.print("Ingrese el nombre: ");
        String nombre = entrada.nextLine();
        System.out.print("Ingrese telefono: ");
        long telefono = entrada.nextLong();
        Direccion direccion = nuevaDireccion();
        Dueno dueno = new Dueno(nombre, telefono, direccion);
        duenos.put(telefono, dueno);
        System.out.println("Dueno agregada con exito");
    }

    public static Direccion nuevaDireccion() {
        System.out.println("Ingrese la calle: ");
        String calle = entrada.nextLine();
        System.out.println("Ingrese el numero exterior ");
        short numero = entrada.nextShort();
        entrada.nextLine();
        System.out.println("Ingrese la colonia: ");
        String colonia = entrada.nextLine();
        System.out.println("Ingrese la alcaldia: ");
        String alcaldia = entrada.nextLine();
        System.out.println("Ingrese el estado: ");
        String estado = entrada.nextLine();
        System.out.println("Ingrese el codigo postal: ");
        int codigoPostal = entrada.nextInt();
        
        return new Direccion(calle, numero, colonia, alcaldia, estado, codigoPostal);
    }
    
    public static void modificarDireccion(Direccion direccion) {
        System.out.println("\n----Modificador de direccion----");
        System.out.println("1. Modificar la calle");
        System.out.println("2. Modificar el numero exterior");
        System.out.println("3. Modificar la colonia");
        System.out.println("1. Modificar la alcaldia");
        System.out.println("5. Modificar el estado");
        System.out.println("6. Modificar el codigo postal");
        System.out.println("0. Salir");
        int opcion = entrada.nextInt();
        entrada.nextLine();

        switch (opcion) {
            case 1:
                System.out.println("Ingrese la calle: ");    
                String calle = entrada.nextLine();
                direccion.setCalle(calle);
                break;
        
            case 2:
                System.out.println("Ingrese el numero exterior ");
                short numero = entrada.nextShort();
                direccion.setNumero(numero);
                break;
            
            case 3:
                System.out.println("Ingrese la colonia: ");
                String colonia = entrada.nextLine();
                direccion.setColonia(colonia);
                break;
        
            case 4:
                System.out.println("Ingrese la alcaldia: ");
                String alcaldia = entrada.nextLine();
                direccion.setAlcaldia(alcaldia);
                break;

            case 5:
                System.out.println("Ingrese el estado: ");
                String estado = entrada.nextLine();
                direccion.setEstado(estado);
                break;

            case 6:
                System.out.println("Ingrese el codigo postal: ");
                int codigoPostal = entrada.nextInt();
                direccion.setCodigoPostal(codigoPostal);
                break;

            case 0:
                break;
            
            default:
                System.out.println("Opcion invalida");
               break;
        }
    }
}
