package entregas.sergioMayen.Reto7;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numDias = Ingestas.validarNumeroDias(scanner);

        Encuesta encuesta = new Encuesta(numDias);
        encuesta.realizarEncuesta(scanner);

        System.out.println("Resultados de la encuesta:");
        System.out.println(encuesta);

        // Cerrar el scanner al finalizar
        scanner.close();
    }
}
