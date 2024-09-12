package Arboles.controller;
import Arboles.model.*;
import Arboles.view.*;

import java.util.Scanner;

public class SistemaEncuestasController {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear paciente
        Paciente paciente = new Paciente("Jose Manuel R.");

        // Interacción con el usuario
        while (true) {
            System.out.println("Seleccione día (1-5) o -1 para salir:");
            int numeroDia = scanner.nextInt();
            if (numeroDia == -1) {
                break;
            }

            Dia dia = new Dia();

            // Interacción para cada ingesta
            for (int i = 1; i <= 5; i++) {
                Ingesta ingesta = new Ingesta(null); // Aquí puedes pasar el objeto Alimento si lo deseas

                System.out.println("Seleccione ingesta (1-Desayuno, 2-Media mañana, 3-Almuerzo, 4-Merienda, 5-Cena, -1-Menú anterior):");
                int tipoIngesta = scanner.nextInt();
                if (tipoIngesta == -1) {
                    break;
                }

                System.out.println("Ingrese alimentos para la ingesta del día " + numeroDia + " (" + tipoIngesta + "):");
                while (true) {
                    System.out.println("Ingrese un alimento (-1 para terminar / -2 para listar alimentos ingresados):");
                    String nombreAlimento = scanner.next();

                    if (nombreAlimento.equals("-1")) {
                        break;
                    } else if (nombreAlimento.equals("-2")) {
                        // Listar alimentos ingresados
                        mostrarIngestas(dia);
                    } else {
                        ingesta.alimento = new Alimento(nombreAlimento);
                        agregarIngestaAlTipo(dia, tipoIngesta, ingesta);
                    }
                }
            }

            // Agregar el día a la encuesta
            paciente.agregarEncuesta(dia);
        }

        // Mostrar datos almacenados utilizando la vista
        SistemaEncuestasView.mostrarDatosAlmacenados(paciente);
    }

    // Método auxiliar para agregar una ingesta al tipo específico de día
    private static void agregarIngestaAlTipo(Dia dia, int tipoIngesta, Ingesta ingesta) {
        switch (tipoIngesta) {
            case 1:
                agregarIngesta(dia.desayuno, ingesta);
                break;
            case 2:
                agregarIngesta(dia.mediaManana, ingesta);
                break;
            case 3:
                agregarIngesta(dia.almuerzo, ingesta);
                break;
            case 4:
                agregarIngesta(dia.merienda, ingesta);
                break;
            case 5:
                agregarIngesta(dia.cena, ingesta);
                break;
            default:
                System.out.println("Tipo de ingesta no válido.");
        }
    }

    // Método auxiliar para agregar una ingesta a la lista de ingestas
    private static void agregarIngesta(Ingesta tipoIngesta, Ingesta nuevaIngesta) {
        if (tipoIngesta == null) {
            tipoIngesta = nuevaIngesta;
        } else {
            Ingesta actual = tipoIngesta;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevaIngesta;
        }
    }

    // Método auxiliar para mostrar las ingestas de un día
    private static void mostrarIngestas(Dia dia) {
        System.out.println("Ingestas del día " + dia);
        mostrarIngesta(dia.desayuno, "Desayuno");
        mostrarIngesta(dia.mediaManana, "Media mañana");
        mostrarIngesta(dia.almuerzo, "Almuerzo");
        mostrarIngesta(dia.merienda, "Merienda");
        mostrarIngesta(dia.cena, "Cena");
    }

    // Método auxiliar para mostrar una ingesta específica
    private static void mostrarIngesta(Ingesta tipoIngesta, String tipo) {
        System.out.print(tipo + ": ");
        while (tipoIngesta != null) {
            System.out.print(tipoIngesta.alimento.nombre + " ");
            tipoIngesta = tipoIngesta.siguiente;
        }
        System.out.println();
    }
}
