import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       int filas = 15;
       int columnas = 10;
       String[][] matriz = new String[filas][columnas];
         inicializarMatriz(matriz);
         opciones(matriz);
    }
    public static void inicializarMatriz(String[][] matriz){
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j <matriz[i].length ; j++) {
                matriz[i][j] = " ";
            }
        }
    }
    public static void imprimirMatriz(String[][] matriz, int maxCeldaLength) {
        System.out.print("   ");
        for (char c = 'A'; c <= 'J'; c++) {
            System.out.print("| " + c + "       ");
        }
        System.out.println("|");

        System.out.print("   ");
        for (int i = 0; i < 10; i++) {
            System.out.print("+---------");
        }
        System.out.println("+");

        for (int i = 0; i < matriz.length; i++) {

            String numeroFila = String.format("%2d", i + 1);

            System.out.print(numeroFila + " |");
            for (int j = 0; j < 10; j++) {
                String contenido = "";
                if (j < matriz[i].length) {
                    contenido = matriz[i][j];
                }

                contenido = String.format("%-" + maxCeldaLength + "s", contenido);

                System.out.print(" " + contenido + " |");
            }
            System.out.println();
        }
    }

    public static void opciones(String[][] matriz) {
        Scanner scanner = new Scanner(System.in);
        int filaActual = 0;
        int columnaActual = 0;
        int maxCeldaLength = 7;

        while (true) {
            imprimirMatriz(matriz, maxCeldaLength);

            System.out.println("\nOpciones:");
            System.out.println("W - Mover arriba");
            System.out.println("A - Mover izquierda");
            System.out.println("S - Mover abajo");
            System.out.println("D - Mover derecha");
            System.out.println("E - Agregar texto");
            System.out.println("Q - Salir");

            System.out.println("Posición actual: Fila " + (filaActual + 1) + ", Columna " + (char) ('A' + columnaActual));

            System.out.print("Ingrese una opción: ");
            String opcion = scanner.nextLine().toUpperCase();

            switch (opcion) {
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
                    if (filaActual < 9) {
                        filaActual++;
                    }
                    break;
                case "D":
                    if (columnaActual < 9) {
                        columnaActual++;
                    }
                    break;
                case "E":
                    System.out.print("Texto a agregar: ");
                    String texto = scanner.nextLine();

                    if (texto.length() > maxCeldaLength) {
                        texto = texto.substring(0, maxCeldaLength);
                    }

                    matriz[filaActual][columnaActual] = texto;
                    break;
                case "Q":
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }

}
