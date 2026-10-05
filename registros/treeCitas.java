package registros;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.TreeSet;
import datos.Cita;

public class treeCitas{
    // Definición del TreeSet
    private static TreeSet<Cita> citas = new TreeSet<>();

    public static TreeSet<Cita> getCitas() {
        return citas;
    }

    // Método para registrar una cita
    public static boolean agregarCita(Cita cita) {
        return citas.add(cita);
        //es de tipo boolean porque así esta definida add para treeSet, true si pudo, false si es duplicado
    }

    // Método para mostrar todas las citas
    public static void mostrarCitas() {
        if (citas.isEmpty()) {
            System.out.println("No hay citas registradas.");
            return;
        }
        //Si hay registradas, muestra una por una con for-each con el metodo de Cita.java
        for (Cita cita : citas) {
            cita.mostrarCita();
        }
    }

    //metodo que nos dice las citas que pertenecen a una fecha en especifico
    public static ArrayList<Cita> buscarCitasPorFecha(LocalDate fecha) {
        ArrayList<Cita> resultados = new ArrayList<>();
        for (Cita cita : citas) {
            if (cita.getFecha().equals(fecha)) {
                resultados.add(cita);
            }
        }
        return resultados;
    }
}