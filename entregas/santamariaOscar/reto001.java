package Reto001;

import java.util.Scanner;

public class Reto001 {
    public static void main(String[] args) {
        int filas = 15;
        int columnas = 10;

        String[][] hojaCalculo = new String[filas][columnas];
        int filaActual = 0;
        int columnaActual = 0;

        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            mostrarHojaCalculo(hojaCalculo, filaActual, columnaActual);
            System.out.print("Ingresa un comando (W/A/S/D/F/Q): ");
            String comando = scanner.nextLine().toUpperCase();

            switch (comando) {
                case "W":
                    if (filaActual > 0) {
                        filaActual--;
                    }
                    break;
                case "A":
                    if (columnaActual > 0) {
                        columnaActual--;
                    }
                    break;
                case "S":
                    if (filaActual < filas - 1) {
                        filaActual++;
                    }
                    break;
                case "D":
                    if (columnaActual < columnas - 1) {
                        columnaActual++;
                    }
                    break;
                case "E":
                    System.out.print("Ingresa el texto para la celda: ");
                    String texto = scanner.nextLine();
                    texto = texto.length() > 7 ? texto.substring(0, 7) : String.format("%7s", texto);
                    hojaCalculo[filaActual][columnaActual] = texto;
                    break;
                case "Q":
                    salir = true;
                    System.out.println("¡Programa finalizado!");
                    break;
                default:
                    System.out.println("Comando no válido. Usa W/A/S/D/F/Q.");
            }
        }
    }

    public static void mostrarHojaCalculo(String[][] hojaCalculo, int filaActual, int columnaActual) {
        int filas = hojaCalculo.length;
        int columnas = hojaCalculo[0].length;

        System.out.println("\nHoja de Cálculo:");


        System.out.print("   ");
        for (int j = 0; j < columnas; j++) {
            System.out.print((char) ('A' + j) + "      ");
        }
        System.out.println();


        System.out.print("   ");
        for (int j = 0; j < columnas; j++) {
            System.out.print("-------");
        }
        System.out.println();


        for (int i = 0; i < filas; i++) {
            System.out.print(String.format("%2d ", i + 1));
            for (int j = 0; j < columnas; j++) {
                String celda = hojaCalculo[i][j];
                if (i == filaActual && j == columnaActual) {
                    System.out.print("[" + celda + "] ");
                } else {
                    System.out.print(" " + celda + "  ");
                }
            }
            System.out.println();
        }
        System.out.println();

    }
}
