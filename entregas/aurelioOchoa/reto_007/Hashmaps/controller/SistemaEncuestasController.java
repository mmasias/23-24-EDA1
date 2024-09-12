package Hashmaps.controller;
import Hashmaps.view.SistemaEncuestasView;
import Hashmaps.model.*;
import java.util.Scanner;

public class SistemaEncuestasController {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Crear paciente
            Paciente paciente = new Paciente("Aurelio Ochoa");

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
                    Ingesta ingesta = new Ingesta();

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
                            for (Alimento alimento : ingesta.alimentos) {
                                System.out.println(alimento.nombre);
                            }
                        } else {
                            ingesta.agregarAlimento(nombreAlimento);
                        }
                    }

                    dia.agregarIngesta(Integer.toString(tipoIngesta), ingesta);
                }

                // Agregar el día a la encuesta
                Encuesta encuesta = paciente.encuestas.getOrDefault(Integer.toString(numeroDia), new Encuesta());
                encuesta.agregarDia(numeroDia, dia);
                paciente.agregarEncuesta(Integer.toString(numeroDia), encuesta);
            }

            // Mostrar datos almacenados utilizando la vista
            SistemaEncuestasView.mostrarDatosAlmacenados(paciente);
        }
    }
}
