package entregas.necoMartinez;

import java.util.Scanner;

public class hojaCalculo {
    public static void main(String[] args) {
        int filas = 15;
        int columnas = 10;
        int filaActual = 0;
        int columnaActual = 0;

        String[][] hojaCalculo = new String[filas][columnas];
        inicializar(hojaCalculo);

        ejecutarBucle(hojaCalculo, filaActual, columnaActual);

        System.out.println("Programa finalizado.");
    }

    public static void ejecutarBucle(String[][] hojaCalculo, int filaActual, int columnaActual) {
        Scanner scanner = new Scanner(System.in);
        String comando = "";

        while (!comando.equals("F")) {
            imprimirHoja(hojaCalculo);
            imprimirCeldaActual(filaActual, columnaActual);

            System.out.print("CMDs: [W] Arriba, [S] Abajo, [A] Izquierda, [D] Derecha, [E] Escribir, [F] Salir - Ingrese comando:");
            comando = scanner.nextLine().trim().toUpperCase();

            switch (comando) {
                case "W":
                    if (filaActual > 0) {
                        filaActual--;
                    } else {
                        System.out.println("No puedes moverte más arriba");
                    }
                    break;
                case "A":
                    if (columnaActual > 0) {
                        columnaActual--;
                    } else {
                        System.out.println("No puedes moverte más a la izquierda");
                    }
                    break;
                case "S":
                    if (filaActual < hojaCalculo.length - 1) {
                        filaActual++;
                    } else {
                        System.out.println("No puedes moverte más abajo");
                    }
                    break;
                case "D":
                    if (columnaActual < hojaCalculo[0].length - 1) {
                        columnaActual++;
                    } else {
                        System.out.println("No puedes moverte más a la derecha");
                    }
                    break;
                case "F":
                    System.out.println("Programa finalizado");
                    return;
                default:
                    if (comando.length() <= 7) {
                        hojaCalculo[filaActual][columnaActual] = comando;
                    } else {
                        hojaCalculo[filaActual][columnaActual] = comando.substring(0, 7);
                    }
                    break;
            }
        }
    }

    public static void inicializar(String[][] hojaCalculo) {
        for (int i = 0; i < hojaCalculo.length; i++) {
            for (int j = 0; j < hojaCalculo[i].length; j++) {
                hojaCalculo[i][j] = "";
            }
        }
    }

    public static void imprimirHoja(String[][] hojaCalculo) {
        System.out.print("\t\t");
        for (int i = 0; i < hojaCalculo[0].length; i++) {
            System.out.print((char) ('A' + i) + "\t\t\t");
        }
        System.out.println();

        System.out.print("\t\t");
        for (int i = 0; i < hojaCalculo[0].length; i++) {
            System.out.print("--------\t");
        }
        System.out.println();

        for (int i = 0; i < hojaCalculo.length; i++) {
            System.out.print(i + 1 + "\t|\t");
            for (int j = 0; j < hojaCalculo[i].length; j++) {
                String celda = hojaCalculo[i][j];
                if (celda.length() > 7) {
                    celda = celda.substring(0, 7);
                }

                int espacios = 9 - celda.length();
                int espaciosIzquierda = espacios / 2;
                int espaciosDerecha = espacios - espaciosIzquierda;


                for (int k = 0; k < espaciosIzquierda; k++) {
                    System.out.print(" ");
                }
                System.out.print(celda);
                for (int k = 0; k < espaciosDerecha; k++) {
                    System.out.print(" ");
                }
                System.out.print("|\t");
            }
            System.out.println();
            System.out.print("\t|\t");
            for (int j = 0; j < hojaCalculo[i].length; j++) {
                System.out.print("--------\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void imprimirCeldaActual(int fila, int columna) {
        char letra = (char) ('A' + columna);
        int numero = fila + 1;
        System.out.println("Celda actual: " + letra + numero);
        System.out.println();
    }

    public static void editar(String[][] hojaCalculo, int fila, int columna, Scanner scanner) {
        System.out.print("Ingrese el nuevo valor para la celda: ");
        String nuevoValor = scanner.nextLine().trim();
        hojaCalculo[fila][columna] = nuevoValor;
        System.out.println("El valor de la celda ha sido actualizado.");
    }
}
