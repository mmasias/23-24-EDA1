package Arboles.view;
import Arboles.model.*;

public class SistemaEncuestasView {

    public static void mostrarDatosAlmacenados(Paciente paciente) {
        System.out.println("Paciente: " + paciente.nombre);

        // Mostrar encuestas
        Encuesta encuesta = paciente.encuestas;
        if (encuesta != null && encuesta.root != null) {
            System.out.println("    Encuestas:");

            // Mostrar días
            inOrderTraversal(encuesta.root);
        } else {
            System.out.println("No hay encuestas almacenadas.");
        }
    }

    // Recorrido in-order para mostrar los días y sus ingestas
    private static void inOrderTraversal(Dia dia) {
        if (dia != null) {
            inOrderTraversal(dia.desayuno, "Desayuno");
            inOrderTraversal(dia.mediaManana, "Media mañana");
            inOrderTraversal(dia.almuerzo, "Almuerzo");
            inOrderTraversal(dia.merienda, "Merienda");
            inOrderTraversal(dia.cena, "Cena");

            // Recursión para los siguientes días
            inOrderTraversal(dia.siguiente);

            // Puedes agregar más lógica aquí según sea necesario
        }
    }

    // Método auxiliar para mostrar una ingesta específica
    private static void inOrderTraversal(Ingesta ingesta, String tipo) {
        if (ingesta != null) {
            System.out.println("        " + tipo + ":");
            mostrarAlimentos(ingesta);
        }
    }

    // Método auxiliar para mostrar los alimentos de una ingesta
    private static void mostrarAlimentos(Ingesta ingesta) {
        while (ingesta != null) {
            System.out.println("            " + ingesta.alimento.nombre);
            ingesta = ingesta.siguiente;
        }
    }
}
