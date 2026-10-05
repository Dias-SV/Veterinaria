import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
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
            System.out.println("5. Consultar historial de consultas");
            System.out.println("6. Consultar mascotas");
            System.out.println("7. Consultar duenos");
            System.out.println("8. Eliminar mascota");
            System.out.println("9. Agendar Cita");
            System.out.println("10. Modificar Cita");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");
            opcionM = entrada.nextInt();
            entrada.nextLine();
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
                        System.out.print("Numero de telefono de dueño: ");
                        long telefono = entrada.nextLong();
                        entrada.nextLine();
                        Dueno dueno = duenos.get(telefono);
                        while (dueno == null) {
                            System.out.println("No hay ningun dueño registrado con ese numero");
                            System.out.print("Ingrese el numero de telefono del dueño: ");
                            telefono = entrada.nextLong();
                            entrada.nextLine();
                            dueno = duenos.get(telefono);
                        }
                        registrarMascota(telefono);
                    }
                    break;

                case 3:
                    System.out.println();
                    registrarDueno();
                    break;

                case 4:
                    System.out.println();
                    if (duenos.isEmpty()) {
                        System.out.println("No hay dueños registrados");
                    } else {
                        System.out.print("Numero de telefono de dueño: ");
                        long telefono = entrada.nextLong();
                        entrada.nextLine();
                        Dueno dueno = duenos.get(telefono);
                        while (dueno == null) {
                            System.out.println("No hay ningun dueño registrado con ese numero");
                            System.out.print("Ingrese el numero de telefono del dueño: ");
                            telefono = entrada.nextLong();
                            entrada.nextLine();
                            dueno = duenos.get(telefono);
                        }

                        do {
                            System.out.println("-----Modificador de registros-----");
                            System.out.println("1. Modificar dueño");
                            System.out.println("2. Modificar mascota");
                            System.out.println("3. Modificar consulta");
                            System.out.println("0. Salir");
                            opcionS = entrada.nextInt();
                            entrada.nextLine();
                            switch (opcionS) {
                                case 1:
                                    modificarDueno(dueno);
                                    break;

                                case 2:
                                    if (dueno.getMascotas().isEmpty()) {
                                        System.out.println("No hay ninguna mascota registrada");
                                    } else {
                                        System.out.print("Ingrese el nombre de la mascota: ");
                                        String nombre = entrada.nextLine();
                                        Mascota mascota = dueno.getMascota(nombre);
                                        while (mascota == null) {
                                            System.out.println("No hay ninguna mascota registrada con ese nombre");
                                            System.out.print("Ingrese el nombre de la mascota nuevamente: ");
                                            nombre = entrada.nextLine();
                                            mascota = dueno.getMascota(nombre);
                                        }
                                        modificarMascota(mascota);
                                    }
                                    break;

                                case 3:
                                    if (dueno.getMascotas().isEmpty()) {
                                        System.out.println("No hay ninguna mascota registrada");
                                    } else {
                                        System.out.print("Ingrese el nombre de la mascota: ");
                                        String nombre = entrada.nextLine();
                                        Mascota mascota = dueno.getMascota(nombre);
                                        while (mascota == null) {
                                            System.out.println("No hay ninguna mascota registrada con ese nombre");
                                            System.out.print("Ingrese el nombre de la mascota nuevamente: ");
                                            nombre = entrada.nextLine();
                                            mascota = dueno.getMascota(nombre);
                                        }

                                        System.out.println("Ingrese la fecha de consulta(dd/mm/aaaa)");
                                        System.out.print("Dia: ");
                                        int dia = entrada.nextInt();
                                        System.out.print("Mes: ");
                                        int mes = entrada.nextInt();
                                        System.out.print("Año: ");
                                        int ano = entrada.nextInt();
                                        entrada.nextLine();
                                        LocalDate fecha = LocalDate.of(ano, mes, dia);
                                        Consulta consulta = mascota.getConsulta(fecha);
                                        if (consulta == null) {
                                            System.out.println("No se tiene ninguna consulta con esta fecha");
                                        } else {
                                            modificarConsulta(consulta);
                                        }
                                    }
                                    break;

                                case 0:
                                    System.out.println("Cerrando submenu...");
                                    break;
                            
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
                        entrada.nextLine();
                        Dueno dueno = duenos.get(telefono);
                        while (dueno == null) {
                            System.out.println("No hay ningun dueño registrado con ese numero");
                            System.out.print("Ingrese el numero de telefono del dueño: ");
                            telefono = entrada.nextLong();
                            entrada.nextLine();
                            dueno = duenos.get(telefono);
                        }

                        if (dueno.getMascotas().isEmpty()) {
                            System.out.println("No hay ninguna mascota registrada");
                        } else {
                            System.out.print("Ingrese el nombre de la mascota: ");
                            String nombre = entrada.nextLine();
                            Mascota mascota = dueno.getMascota(nombre);
                            while (mascota == null) {
                                System.out.println("No hay ninguna mascota registrada con ese nombre");
                                System.out.print("Ingrese el nombre de la mascota nuevamente: ");
                                nombre = entrada.nextLine();
                                mascota = dueno.getMascota(nombre);
                            }
                            mascota.mostrarConsultas();
                        }
                    }
                    break;

                case 6:
                    System.out.println();
                    if (duenos.isEmpty()) {
                        System.out.println("No hay duenos registrados");    
                    } else {
                        System.out.print("Numero de telefono de dueño: ");
                        long telefono = entrada.nextLong();
                        entrada.nextLine();
                        Dueno dueno = duenos.get(telefono);
                        while (dueno == null) {
                            System.out.println("No hay ningun dueño registrado con ese numero");
                            System.out.print("Ingrese el numero de telefono del dueño: ");
                            telefono = entrada.nextLong();
                            entrada.nextLine();
                            dueno = duenos.get(telefono);
                        }
                        if (dueno.getMascotas().isEmpty()) {
                            System.out.println("No hay ninguna mascota registrada");
                        } else {
                            dueno.mostrarMascotas();
                        }

                    }
                    break;
                
                case 7:
                    System.out.println();
                    if (duenos.isEmpty()) {
                        System.out.println("No hay duenos registrados");    
                    } else {
                        ListaDueno.mostrarDuenos();
                    }
                    break;
                case 8:
                    System.out.printf("Ingresa el numero de teléfono del dueño de la mascota a eliminar: ");
                    long telefono=entrada.nextLong();
                    entrada.nextLine();
                    Dueno dueno = duenos.get(telefono); 
                    while(dueno==null){
                        System.out.println("Ese numero no está registrado, desea intentarlo de nuevo (s) o salir(n)");
                        String opcaux=entrada.nextLine().trim();
                        if(opcaux.equals("s")){
                            System.out.println("Ingresa el nuevo telefono: ");
                            telefono=entrada.nextLong();
                            entrada.nextLine();
                            dueno = duenos.get(telefono);
                        }else{
                            System.out.println("Saliendo...");
                            break;
                        }
                    }
                    eliminarMascota(dueno);
                break;
                case 9:
                    System.out.println("Ingrese el numero de telefono del dueño que agenda la cita");
                    telefono=entrada.nextLong();
                    entrada.nextLine();
                    dueno = duenos.get(telefono); 
                    while(dueno==null){
                        System.out.println("Ese numero no está registrado, desea intentarlo de nuevo (s) o salir(n)");
                        String opcaux=entrada.nextLine().trim();
                        if(opcaux.equals("s")){
                            System.out.println("Ingresa el nuevo telefono: ");
                            telefono=entrada.nextLong();
                            entrada.nextLine();
                            dueno = duenos.get(telefono);
                        }else{
                            System.out.println("Saliendo...");
                            break;
                        }
                    }
                    registrarCita(dueno);
                    break;
                case 10:
                    System.out.println("Ingrese el numero de telefono del dueño que agenda la cita");
                    telefono=entrada.nextLong();
                    entrada.nextLine();
                    dueno = duenos.get(telefono); 
                    while(dueno==null){
                        System.out.println("Ese numero no está registrado, desea intentarlo de nuevo (s) o salir(n)");
                        String opcaux=entrada.nextLine().trim();
                        if(opcaux.equals("s")){
                            System.out.println("Ingresa el nuevo telefono: ");
                            telefono=entrada.nextLong();
                            entrada.nextLine();
                            dueno = duenos.get(telefono);
                        }else{
                            System.out.println("Saliendo...");
                            break;
                        }
                    }
                    modificarCita(dueno);
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
                if (telefono == -1) {
                    System.out.println("Cancelando registro de consulta...");
                    return;
                }
                dueno = duenos.get(telefono);
                System.out.println("No hay ninguna mascota registrada");
                System.out.print("¿Desea registrar una nueva mascota? (s/n): ");
                entrada.nextLine();
                opc = entrada.nextLine().trim();
                
                if (opc.equalsIgnoreCase("s")) {
                    Mascota mascota = registrarMascota(telefono);
                    datosConsulta(mascota);
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
                        Mascota mascota = registrarMascota(telefono);
                        datosConsulta(mascota);
                        return;
                    }else{
                        System.out.println("Cancelando registro de consulta...");
                        return;
                    }
            } else {
                System.out.print("Ingrese el nombre de la mascota: ");
                String nombre = entrada.nextLine();
                Mascota mascota = dueno.getMascota(nombre);
                while (mascota == null) {
                    System.out.println("No hay ninguna mascota registrada con ese nombre");
                    System.out.print("Ingrese el nombre de la mascota nuevamente: ");
                    nombre = entrada.nextLine();
                    mascota = dueno.getMascota(nombre);
                }
                datosConsulta(mascota);
                return;
            }
        }
    }

    public static void datosConsulta(Mascota mascota) {
        System.out.println("Datos de consulta:");
        System.out.println("Ingrese la fecha (dd/mm/aaaa)");
        System.out.print("Dia: ");
        int dia = entrada.nextInt();
        System.out.print("Mes: ");
        int mes = entrada.nextInt();
        System.out.print("Año: ");
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
    }

    public static Mascota registrarMascota(long telefono) {
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
        Mascota mascota = new Mascota(nombre, especie, raza, edad);
        dueno.agregarMascota(mascota);
        System.out.println("Mascota agregada con exito"); 
        return mascota;
    }

    public static void registrarDueno() {
        entrada.nextLine();//limpieza necesaria, habia errores
        System.out.print("Ingrese el nombre: ");
        String nombre = entrada.nextLine();
        long telefono = pedirTelefonoNuevo();
        if (telefono == -1) {
            System.out.println("Registro de dueño cancelado");
            return;
        }
        Direccion direccion = nuevaDireccion();
        ListaDueno.agregarDueno(new Dueno(nombre, telefono, direccion));
        System.out.println("Dueno agregado con exito");
    }
    
    public static long registrarDueno2() {
        System.out.print("Ingrese el nombre: ");
        String nombre = entrada.nextLine();
        long telefono = pedirTelefonoNuevo();
        if (telefono == -1) {
            System.out.println("Registro de dueño cancelado");
            return -1;
        }
        Direccion direccion = nuevaDireccion();
        ListaDueno.agregarDueno(new Dueno(nombre, telefono, direccion));
        System.out.println("Dueno agregado con exito");
        return telefono;
    }

    public static long pedirTelefonoNuevo() {
        System.out.print("Ingrese telefono: ");
        long telefono = entrada.nextLong();
        entrada.nextLine();
        while (ListaDueno.existeTelefono(telefono)) {
            System.out.println("Ya existe un dueño registrado con ese telefono");
            System.out.print("Ingrese otro telefono (o 0 para cancelar): ");
            telefono = entrada.nextLong();
            entrada.nextLine();
            if (telefono == 0) {
                return -1;
            }
        }
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
        entrada.nextLine();
        return new Direccion(calle, numero, colonia, alcaldia, estado, codigoPostal);
    }

    public static void modificarDueno(Dueno dueno) {
        int opcion;
        do {
            System.out.println("\n-----Datos-----");
            System.out.println("1. Modificar nombre");
            System.out.println("2. Modificar telefono");
            System.out.println("3. Modificar direccion");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");
            opcion = entrada.nextInt();
            entrada.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("Inserte el nuevo nombre: ");
                    String nombre = entrada.nextLine();
                    dueno.setNombre(nombre);
                    System.out.println("Nombre modificado correctamente");
                    break;
                                            
                case 2:
                    System.out.println("Inserte el nuevo telefono: ");
                    long numero = entrada.nextLong();
                    entrada.nextLine();
                    if (ListaDueno.cambiarTelefono(dueno, numero)) {
                        System.out.println("Telefono modificado correctamente");
                    } else {
                        System.out.println("Ya existe un dueño registrado con ese telefono");
                    }
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
        } while (opcion != 0);
    }

    public static void modificarDireccion(Direccion direccion) {
        int opcion;
        do {
            System.out.println("\n----Modificador de direccion----");
            System.out.println("1. Modificar la calle");
            System.out.println("2. Modificar el numero exterior");
            System.out.println("3. Modificar la colonia");
            System.out.println("4. Modificar la alcaldia");
            System.out.println("5. Modificar el estado");
            System.out.println("6. Modificar el codigo postal");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");
            opcion = entrada.nextInt();
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
                    entrada.nextLine();
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
                    entrada.nextLine();
                    direccion.setCodigoPostal(codigoPostal);
                    break;

                case 0:
                    System.out.println("Cerrando submenu...");
                    break;
                
                default:
                    System.out.println("Opcion invalida");
                break;
            }
        } while (opcion != 0);
    }

    public static void modificarMascota(Mascota mascota) {
        int opcion;
        do {
            System.out.println("\n----Modificador de direccion----");
            System.out.println("1. Modificar el nombre");
            System.out.println("2. Modificar la especie");
            System.out.println("3. Modificar la raza");
            System.out.println("4. Modificar la edad");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");
            opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre: ");
                    String nombre = entrada.nextLine();
                    mascota.setNombre(nombre);
                    break;
            
                case 2:
                    System.out.print("Ingrese la especie: ");
                    String especie = entrada.nextLine();
                    mascota.setEspecie(especie);
                    break;
                
                case 3:
                    System.out.print("Ingrese la raza: ");
                    String raza = entrada.nextLine();
                    mascota.setRaza(raza);
                    break;
            
                case 4:
                    System.out.print("Ingrese la edad: ");
                    byte edad = entrada.nextByte();
                    entrada.nextLine();
                    mascota.setEdad(edad);
                    break;

                case 0:
                    System.out.println("Cerrando submenu...");
                    break;
                
                default:
                    System.out.println("Opcion invalida");
                break;
            }
        } while (opcion != 0);
    }
    
    public static void modificarConsulta(Consulta consulta) {
        int opcion;
        do{
            System.out.println("\n----Modificador de consulta----");
            System.out.println("1. Modificar la fecha");
            System.out.println("2. Modificar el motivo");
            System.out.println("3. Modificar el diagnostico");
            System.out.println("4. Modificar el tratamiento");
            System.out.println("0. Salir");
            opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese la fecha (dd/mm/aaaa)");
                    System.out.print("Dia: ");
                    int dia = entrada.nextInt();
                    System.out.print("Mes: ");
                    int mes = entrada.nextInt();
                    System.out.print("Año: ");
                    int ano = entrada.nextInt();
                    entrada.nextLine();
                    LocalDate fecha = LocalDate.of(ano, mes, dia);
                    consulta.setFecha(fecha);
                    break;
            
                case 2:
                    System.out.print("Ingrese el motivo de consulta: ");
                    String motivo = entrada.nextLine();
                    consulta.setMotivo(motivo);
                    break;
                
                case 3:
                    System.out.print("Ingrese el diagnostico: ");
                    String diagnostico = entrada.nextLine();
                    consulta.setDiagnostico(diagnostico);
                    break;
            
                case 4:
                    System.out.print("Ingrese el tratamiento: ");
                    String tratamiento = entrada.nextLine();
                    consulta.setTratamiento(tratamiento);
                    break;

                case 0:
                    System.out.println("Cerrando submenu...");
                    break;
                
                default:
                    System.out.println("Opcion invalida");
                break;
            }
        } while (opcion != 0);
    }

    public static void eliminarMascota(Dueno dueno){
        if(dueno.getMascotas().isEmpty()){
            System.out.println("Este número no tiene mascotas");
            return;
        }else{
            System.out.println("Las mascotas registradas de este dueno son:");
            dueno.mostrarMascotas();
            System.out.println("Ingrese le nombre de la mascota que se eliminará: ");
            String nombre=entrada.nextLine().trim();
            int band=0;
            do{
                if(!dueno.elimMascota(nombre)){
                    System.out.println("Esa mascota no está registrada, ¿desea intentar con otro nombre?(s/n");
                    String opcaux=entrada.nextLine().trim();
                    if(opcaux.equalsIgnoreCase("s")){
                        System.out.println("Ingrese le nombre de la mascota que se eliminará: ");
                        nombre=entrada.nextLine().trim();
                    }else{
                        System.out.println("Cancelando eliminación...");
                        return;
                    }
                }else{
                    return;
                }
            }while(band!=1);
        }
    }
    public static void registrarCita(Dueno dueno){
        System.out.println("Ingrese el nombre de la mascota que se atenderá en la cita:");
        System.out.println("Las mascotas son:");
        dueno.mostrarMascotas();
        System.out.println("Si quiere ingresar una nueva mascota para la cita ingrese (n_mascota)");
        String nombre=entrada.nextLine().trim();
        Mascota mascota = dueno.getMascota(nombre);
        if (nombre.equalsIgnoreCase("n_mascota")) {
            mascota = registrarMascota(dueno.getTelefono());
        }else{
            while (mascota == null) {
                System.out.println("No hay ninguna mascota registrada con ese nombre");
                System.out.print("Ingrese el nombre de la mascota nuevamente (o escriba salir para cancelar el registro de cita): ");
                nombre = entrada.nextLine();
                if(nombre.equalsIgnoreCase("salir")){
                    System.out.println("Cancelando cita...");
                    return;
                }
                mascota = dueno.getMascota(nombre);
            }
        }
        System.out.println("\nIngrese los datos de la cita:");
        System.out.println("Ingrese la fecha (dd/mm/aaaa)");
        System.out.print("Dia: ");
        int dia=entrada.nextInt();
        System.out.print("Mes: ");
        int mes=entrada.nextInt();
        System.out.print("Año: ");
        int ano=entrada.nextInt();
        entrada.nextLine();
        LocalDate fecha=LocalDate.of(ano, mes, dia);
        System.out.println("Ingrese la hora de la cita (formato 24h):");
        System.out.print("Hora (0-23): ");
        int hour=entrada.nextInt();
        System.out.print("Minuto (0-59): ");
        int minuto=entrada.nextInt();
        LocalTime hora=(LocalTime.of(hour, minuto));
        entrada.nextLine(); // Limpieza de buffer
        System.out.print("Ingrese el motivo de la cita: ");
        String motivo = entrada.nextLine();
        Cita nuevaCita = new Cita(fecha, hora, motivo, dueno, mascota);
        boolean exito = treeCitas.agregarCita(nuevaCita);
        if (exito) {
            System.out.println("Cita agendada exitosamente.");
        } else {
            System.out.println("Error: Ya existe una cita idéntica registrada a esa misma hora.");
        }
        
    }
    public static void modificarCita(Dueno dueno) {
        boolean continuar=true;
        while (continuar){
            System.out.println("Ingrese de la cita a modificar (dd/mm/aaaa):");
            System.out.print("Día: ");
            int dia=entrada.nextInt();
            System.out.print("Mes: ");
            int mes=entrada.nextInt();
            System.out.print("Año: ");
            int ano=entrada.nextInt();
            entrada.nextLine(); // Limpieza de buffer
            LocalDate fechaBusqueda=LocalDate.of(ano, mes, dia);
            //las citas de esa fecha
            ArrayList<Cita> citasDelDia=treeCitas.buscarCitasPorFecha(fechaBusqueda);
            //de esas, sleccionamos las de ese dueño
            ArrayList<Cita> citasIndexadas=new ArrayList<>();
            for (Cita c:citasDelDia) {
                if (c.getDueno().getTelefono()==dueno.getTelefono()) {
                    citasIndexadas.add(c);
                }
            }

            if (citasIndexadas.isEmpty()){
                System.out.println("\nNo existen citas registradas para este dueño en la fecha ("+ fechaBusqueda +")");
                System.out.println("¿Desea intentarlo de nuevo con otra fecha (s) o salir (n)?");
                System.out.print("Opción: ");
                String opcAux=entrada.nextLine().trim();
                if (!opcAux.equalsIgnoreCase("s")){
                    System.out.println("Saliendo de modificación de cita...");
                    return;
                }
            } else {
                //Se encontraron citas
                continuar = false;
                
                //citas encontradas con su índice
                System.out.println("\nCitas encontradas para el " + fechaBusqueda + ":");
                for (int i = 0; i < citasIndexadas.size(); i++) {
                    System.out.println("\nÍndice [" + (i + 1) + "]");
                    citasIndexadas.get(i).mostrarCita();
                }
                
                //Seleccionar la cita por índice
                System.out.print("\nIngrese el número de índice de la cita que desea modificar: ");
                int indiceSeleccionado = entrada.nextInt();
                entrada.nextLine();
                //cita auxiliar que servirá para reemplazar la antigua
                Cita citaAModificar = citasIndexadas.get(indiceSeleccionado-1);

                // Removemos la cita del TreeSet antes de cambiar datos
                //paso necesario ya que sino, con los nuevos datos, romperíamos totalmente el ordenamiento del treeSet
                treeCitas.getCitas().remove(citaAModificar);

                //Seleccion de datos a modificar
                int opcionSubmenu;
                do {
                    System.out.println("1. Modificar Fecha");
                    System.out.println("2. Modificar Hora");
                    System.out.println("3. Modificar Motivo");
                    System.out.println("4. Modificar Mascota");
                    System.out.println("0. Guardar y Salir");
                    System.out.print("Opción: ");
                    opcionSubmenu = entrada.nextInt();
                    entrada.nextLine();
                    switch (opcionSubmenu) {
                        case 1:
                            System.out.println("\nIngrese la nueva fecha (dd/mm/aaaa):");
                            System.out.print("Día: ");
                            int nDia = entrada.nextInt();
                            System.out.print("Mes: ");
                            int nMes = entrada.nextInt();
                            System.out.print("Año: ");
                            int nAno = entrada.nextInt();
                            entrada.nextLine();
                            citaAModificar.setFecha(LocalDate.of(nAno, nMes, nDia));
                            System.out.println("Fecha actualizada correctamente.");
                            break;
                        case 2:
                            System.out.println("\nIngrese la nueva hora (formato 24h):");
                            System.out.print("Hora (0-23): ");
                            int nHora=entrada.nextInt();
                            System.out.print("Minuto (0-59): ");
                            int nMin=entrada.nextInt();
                            entrada.nextLine();
                            citaAModificar.setHora(LocalTime.of(nHora, nMin));
                            System.out.println("Hora actualizada correctamente.");
                            break;

                        case 3:
                            System.out.print("\nIngrese el nuevo motivo: ");
                            String nMotivo=entrada.nextLine();
                            citaAModificar.setMotivo(nMotivo);
                            System.out.println("Motivo actualizado correctamente.");
                            break;

                        case 4:
                            System.out.println("\nMascotas registradas del dueño:");
                            dueno.mostrarMascotas();
                            System.out.print("Ingrese el nombre de la nueva mascota para la cita: ");
                            String nNombreMascota=entrada.nextLine().trim();
                            Mascota nMascota = dueno.getMascota(nNombreMascota);
                            if (nMascota!=null){
                                citaAModificar.setMascota(nMascota);
                                System.out.println("Mascota actualizada correctamente.");
                            } else{
                                System.out.println("No se encontró esa mascota en los datos de su dueño. Se conservó la anterior.");
                            }
                            break;
                        case 0:
                            System.out.println("Guardando cambios...");
                            //se reinsertará la cita original
                            break;

                        default:
                            System.out.println("Opción inválida.");
                            break;
                    }
                } while (opcionSubmenu != 0);

                //Reinsertar cita actualizada al TreeSet
                boolean exito=treeCitas.agregarCita(citaAModificar);
                if (exito){
                    System.out.println("\nCita modificada y reordenada");
                } else{
                    System.out.println("Error: Ya existe una cita idéntica registrada con ese atributo.");
                }
            }
        }
    }
}

