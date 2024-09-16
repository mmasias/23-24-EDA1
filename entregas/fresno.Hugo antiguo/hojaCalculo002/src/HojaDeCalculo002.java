import java.util.Scanner;

public class HojaDeCalculo002 {
    public static void main(String[] args) {
        HojaDeCalculoApp002 app = new HojaDeCalculoApp002();
        app.run();
    }
}

class HojaDeCalculoApp002 {
    private final int FILAS = 15;
    private final int COLUMNAS = 10;
    private String[][] celdas = new String[FILAS][COLUMNAS];
    private int filaActual = 0;
    private int columnaActual = 0;
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                celdas[i][j] = "";
            }
        }

        while (true) {
            mostrarHojaDeCalculo();
            if (!procesarComando()) {
                cerrarScanner();
                break;
            }
        }
    }

    private void mostrarHojaDeCalculo() {
        System.out.print("\t");
        for (int i = 0; i < COLUMNAS; i++) {
            System.out.print((char) ('A' + i) + "\t\t\t");
        }
        System.out.println("\n\t" + "-".repeat(COLUMNAS * 12 - 1));
        for (int i = 0; i < FILAS; i++) {
            System.out.print((i + 1) + " |\t");
            for (int j = 0; j < COLUMNAS; j++) {
                System.out.print(celdas[i][j] + "\t\t\t");
            }
            System.out.println("\n\t" + "-".repeat(COLUMNAS * 12 - 1));
        }

        System.out.println("Celda actual --> (" + (char) ('A' + columnaActual) + (filaActual + 1)+")");
        System.out.println("Presiona 'e' para agregar texto a la celda actual.");
        System.out.println("Presiona 'q' para salir.");
    }

    private boolean procesarComando() {
        System.out.print("Ingresa el comando (w/a/s/d/e/q): ");
        char comando = scanner.nextLine().charAt(0);

        switch (comando) {
            case 'w':
                if (filaActual > 0) filaActual--;
                break;
            case 's':
                if (filaActual < FILAS - 1) filaActual++;
                break;
            case 'a':
                if (columnaActual > 0) columnaActual--;
                break;
            case 'd':
                if (columnaActual < COLUMNAS - 1) columnaActual++;
                break;
            case 'e':
                System.out.print("Ingresa el valor para la celda " + (char) ('A' + columnaActual) + (filaActual + 1) + ": ");
                String entrada = scanner.nextLine();
                celdas[filaActual][columnaActual] = entrada.substring(0, Math.min(entrada.length(), 7));
                break;
            case 'q':
                System.out.println("Saliendo...");
                return false;
            default:
                System.out.println("Comando no válido!");
                break;
        }
        return true;
    }

    private void cerrarScanner() {
        scanner.close();
    }
}
