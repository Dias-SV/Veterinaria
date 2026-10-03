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
        System.out.println("-----Clinica veterinaria-----");
        do {
            System.out.println();
            System.out.println("MENU PRINCIPAL");
            System.out.println("1. Registrar consulta nueva");
            System.out.println("2. Registrar mascota nueva");
            System.out.println("3. Registrar dueño nuevo");
            System.out.println("4. Modificar registros");
            System.out.println("5. Consultar mascotas");
            System.out.println("6. Consultar duenos");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");
            opcionM = entrada.nextInt();
            //La lectura de buffer provocaba doble lectura de datos
            switch (opcionM) {
                case 1:
                    System.out.println();
                    if (duenos.isEmpty()) {
                        System.out.println("No hay dueños registrados");
                    } else {
                        registrarConsulta();
                    }
                    break;

                case 2:
                    System.out.println();
                    if (duenos.isEmpty()) {
                        System.out.println("No hay duenos registrados");
                    } else {
                        registrarMascota();
                    }
                    break;

                case 3:
                    System.out.println();
                    registrarDueno();
                    break;

                case 4:
                    System.out.println();
                    if (duenos.isEmpty()) {
                        System.out.println("No hay registros");
                    } else {
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

                                                case 0:
                                                    System.out.println("Saliendo del submenu");
                                                    break;

                                                default:
                                                    System.out.println("Opcion invalida");
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
                                        entrada.nextLine();//limpieza necesaria, pedía dos veces el telefono aún existiendo
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
                                        entrada.nextLine();
                                        while (dueno == null) {
                                            System.out.println("No hay ningun dueño registrado con ese nombre");
                                            System.out.print("¿Desea registrar un nuevo dueño? (s/n): ");
                                            String opc = entrada.nextLine().trim();
                                            if (opc.equalsIgnoreCase("s")) {
                                            }
            
                                            System.out.print("Ingrese el numero de telefono del dueño: ");
                                            telefono = entrada.nextLong();
                                            dueno = duenos.get(telefono);
                                        }
                                    }
                                    break;

                                case 0:
                                    System.out.println("Cerrando submenu");
                            
                                default:
                                    System.out.println("Opcion invalida");
                                    break;
                            }
                            
                        } while (opcionS != 0);
                        }
                    break;

                case 5:
                    System.out.println();
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
                        if (dueno.getMascotas().isEmpty()) {
                            System.out.println("No hay ninguna mascota registrada");
                        } else {
                            dueno.mostrarMascotas();
                        }
                    }
                    break;
                
                    
                case 6:
                    System.out.println();
                    if (duenos.isEmpty()) {
                        System.out.println("No hay duenos registrados");    
                    } else {
                        ListaDueno.mostrarDuenos();
                    }
                    break;

                case 0:
                    System.out.println("Cerrando programa...");
                    break;

                default:
                    System.out.println("Opcion invalida");
                    break;
            }
            
        } while (opcionM != 0); 
    }

    public static void registrarConsulta() {
        String opc="K";
        entrada.nextLine();
        System.out.print("Ingrese el numero de telefono del dueño: ");
        long telefono = entrada.nextLong();
        entrada.nextLine(); 
        Dueno dueno = duenos.get(telefono);
        if (dueno==null) {
            System.out.println("El teléfono ingresado no pertenece a ningún dueño registrado.");
            System.out.print("¿Desea registrar un nuevo dueño? (s/n): ");
            opc = entrada.nextLine().trim();
            
            if (opc.equalsIgnoreCase("s")) {
                telefono = registrarDueno2();
                dueno = duenos.get(telefono);
                //Bajo la logica dueno no va a tener mascotas, no hay necesidad dell if
                System.out.println("No hay ninguna mascota registrada");
                System.out.print("¿Desea registrar una nueva mascota? (s/n): ");
                entrada.nextLine();
                opc = entrada.nextLine().trim();
                
                if (opc.equalsIgnoreCase("s")) {
                    Mascota mascota = registrarMascotaTelefono(telefono);
                    System.out.println("Datos de consulta:");
                    System.out.println("Ingrese la fecha (dd/mm/aaaa)");
                    System.out.print("Dia: ");
                    int dia = entrada.nextInt();
                    System.out.print("Mes: ");
                    int mes = entrada.nextInt();
                    System.out.print("Ano: ");
                    int ano = entrada.nextInt();
                    entrada.nextLine(); 
                    LocalDate fecha = LocalDate.of(ano, mes, dia);
                    System.out.print("Ingrese el motivo de consulta: ");
                    String motivo = entrada.nextLine();
                    System.out.print("Ingrese el diagnostico: ");
                    String diagnostico = entrada.nextLine();
                    System.out.print("Ingrese el tratamiento: ");
                    String tratamiento = entrada.nextLine();
                    mascota.agregarConsulta(new Consulta(fecha, motivo, diagnostico, tratamiento));
                    System.out.println("Consulta agregada con exito");
                    return;
                } else {
                    System.out.println("Cancelando registro de consulta...");
                    return;
                }
            } else {
                System.out.println("Cancelando registro de consulta...");
                return;
            }
        }else{
            if (dueno.getMascotas().isEmpty()) {
                System.out.println("No hay ninguna mascota registrada");
                System.out.print("¿Desea registrar una nueva mascota? (s/n): ");//Se puede decidir salir o registrar un nuevo dueño.
                opc = entrada.nextLine().trim();

                if (opc.equalsIgnoreCase("s")) {
                        Mascota mascota=registrarMascotaTelefono(telefono);
                        System.out.println("Datos de consulta:");
                        System.out.println("Ingrese la fecha (dd/mm/aaaa)");
                        System.out.print("Dia: ");
                        int dia = entrada.nextInt();
                        System.out.print("Mes: ");
                        int mes = entrada.nextInt();
                        System.out.print("Ano: "); //Corregir la n
                        int ano = entrada.nextInt();
                        entrada.nextLine(); // Limpieza necesaria tras la lectura numérica de la fecha
                        LocalDate fecha = LocalDate.of(ano, mes, dia);
                        System.out.print("Ingrese el motivo de consulta: ");
                        String motivo = entrada.nextLine();
                        System.out.print("Ingrese el diagnostico: ");
                        String diagnostico = entrada.nextLine();
                        System.out.print("Ingrese el tratamiento: ");
                        String tratamiento = entrada.nextLine();
                        mascota.agregarConsulta(new Consulta(fecha, motivo, diagnostico, tratamiento));
                        System.out.println("Consulta agregada con exito");
                        return;//Bandera para terminar el ciclo
                    }else{
                        System.out.println("Cancelando registro de consulta...");
                        return;
                    }
            } else {
                System.out.println("Datos de consulta:");
                System.out.println("Ingrese la fecha (dd/mm/aaaa)");
                System.out.print("Dia: ");
                int dia = entrada.nextInt();
                System.out.print("Mes: ");
                int mes = entrada.nextInt();
                System.out.print("Ano: ");
                int ano = entrada.nextInt();
                entrada.nextLine();
                LocalDate fecha = LocalDate.of(ano, mes, dia);
                System.out.print("Ingrese el motivo de consulta: ");
                String motivo = entrada.nextLine();
                System.out.print("Ingrese el diagnostico: ");
                String diagnostico = entrada.nextLine();
                System.out.print("Ingrese el tratamiento: ");
                String tratamiento = entrada.nextLine();
                System.out.print("Ingrese el nombre de la mascota: ");
                String nombre = entrada.nextLine();
                Mascota mascota = dueno.getMascota(nombre);
                while (mascota == null) {
                    System.out.println("No hay ninguna mascota registrada con ese nombre");
                    System.out.print("Ingrese el nombre de la mascota nuevamente: ");
                    nombre = entrada.nextLine();
                    mascota = dueno.getMascota(nombre);
                }
                mascota.agregarConsulta(new Consulta(fecha, motivo, diagnostico, tratamiento));
                System.out.println("Consulta agregada con exito"); 
                return;
            }
        }
    }

    public static void registrarMascota() {
        entrada.nextLine();//Había un salto de linea atrapado
        System.out.print("Ingrese el nombre: ");
        String nombre = entrada.nextLine();
        System.out.print("Ingrese la especie: ");
        String especie = entrada.nextLine();
        System.out.print("Ingrese la raza: ");
        String raza = entrada.nextLine();
        System.out.print("Ingrese la edad: ");
        byte edad = entrada.nextByte();
        entrada.nextLine(); // Limpieza necesaria tras nextByte
        System.out.print("Ingrese el numero de telefono del dueño: ");
        long telefono = entrada.nextLong();
        entrada.nextLine(); // Limpieza necesaria tras nextLong

        Dueno dueno = duenos.get(telefono);
        while (dueno == null) {
            System.out.println("No hay ningun dueño registrado con ese nombre");
            System.out.print("Ingrese el numero de telefono del dueño: ");
            telefono = entrada.nextLong();
            entrada.nextLine(); // Limpieza necesaria en cada intento del bucle
            dueno = duenos.get(telefono);
        }
        dueno.agregarMascota(new Mascota(nombre, especie, raza, edad));
        System.out.println("Mascota agregada con exito");
    }

    public static Mascota registrarMascotaTelefono(long telefono) {//Nuevo metodo que facilita el añadido de mascotas con telefono para el menu
        System.out.print("Ingrese el nombre: ");
        String nombre = entrada.nextLine();
        System.out.print("Ingrese la especie: ");
        String especie = entrada.nextLine();
        System.out.print("Ingrese la raza: ");
        String raza = entrada.nextLine();
        System.out.print("Ingrese la edad: ");
        byte edad = entrada.nextByte();
        entrada.nextLine(); // Limpieza necesaria tras nextByte
        Dueno dueno = duenos.get(telefono);
        Mascota mascotita = new Mascota(nombre, especie, raza, edad);
        dueno.agregarMascota(mascotita);
        System.out.println("Mascota agregada con exito"); 
        return mascotita;
    }

    public static void registrarDueno() {
        entrada.nextLine();//limpieza necesaria, habia errores
        System.out.print("Ingrese el nombre: ");
        String nombre = entrada.nextLine();
        System.out.print("Ingrese telefono: ");
        long telefono = entrada.nextLong();
        entrada.nextLine(); // Limpieza necesaria tras nextLong
        Direccion direccion = nuevaDireccion();
        Dueno dueno = new Dueno(nombre, telefono, direccion);
        duenos.put(telefono, dueno);
        System.out.println("Dueno agregado con exito");
    }
    
    public static long registrarDueno2() {
        System.out.print("Ingrese el nombre: ");
        String nombre = entrada.nextLine();
        System.out.print("Ingrese telefono: ");
        long telefono = entrada.nextLong();
        entrada.nextLine(); // Limpieza necesaria tras nextLong
        Direccion direccion = nuevaDireccion();
        Dueno dueno = new Dueno(nombre, telefono, direccion);
        duenos.put(telefono, dueno);
        System.out.println("Dueno agregado con exito");
        return telefono;
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
