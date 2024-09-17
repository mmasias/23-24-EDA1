import java.util.Scanner;

public class VisiCalc {

    static final int FILAS = 15;
    static final int COLUMNAS = 10;
    static int filaActual = 0;
    static int columnaActual = 0;
    static boolean edicion = false;
    static String[][] hoja = new String[FILAS][COLUMNAS];

    public static void main(String[] args) {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                hoja[i][j] = "";
            }
        }

        Scanner sc = new Scanner(System.in);

        while (true) {
            imprimirHoja();
            System.out.println("Estás en la fila " + (filaActual + 1) + ", columna " + (char) ('A' + columnaActual));
            System.out.print("Seleccione un comando: [W]Arriba; [A]Izquierda; [S]Abajo; [D]Derecha; [Q]Finalizar programa; [E]Editar: ");

            String comando = sc.nextLine().toUpperCase();

            if (edicion || comando.equals("E")) {
                if (comando.equals("E")) {
                    System.out.print("Ingrese el nuevo valor: ");
                    String nuevoValor = sc.nextLine();
                    hoja[filaActual][columnaActual] = nuevoValor;
                    edicion = false;
                } else {
                    System.out.println("Comando no válido en modo de edición.");
                }
            } else {
                switch (comando) {
                    case "W", "w":
                        moverArriba();
                        break;
                    case "A", "a":
                        moverIzquierda();
                        break;
                    case "S", "s":
                        moverAbajo();
                        break;
                    case "D", "d":
                        moverDerecha();
                        break;
                    case "Q", "q":
                        System.out.println("Finalizando el programa.");
                        sc.close();
                        System.exit(0);
                    case "E", "e":
                        edicion = true;
                        break;
                    default:
                        System.out.println("Comando no válido.");
                }
            }
        }
    }

    public static void imprimirHoja() {
        System.out.print("   ");
        for (int j = 0; j < COLUMNAS; j++) {
            System.out.print("|   " + (char)('A' + j) + "    ");
        }
        System.out.println("|");

        for (int i = 0; i < FILAS; i++) {
            System.out.print((i + 1) < 10 ? "  " + (i + 1) : " " + (i + 1));
            for (int j = 0; j < COLUMNAS; j++) {
                System.out.print("|");
                if (i == filaActual && j == columnaActual) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
                String contenido = hoja[i][j].length() > 7 ? hoja[i][j].substring(0, 7) : hoja[i][j];
                System.out.print(contenido);
                for (int k = contenido.length(); k < 7; k++) {
                    System.out.print(" ");
                }
            }
            System.out.println("|");
        }
    }

    public static void moverArriba() {
        if (filaActual > 0) {
            filaActual--;
        }
    }

    public static void moverIzquierda() {
        if (columnaActual > 0) {
            columnaActual--;
        }
    }

    public static void moverAbajo() {
        if (filaActual < FILAS - 1) {
            filaActual++;
        }
    }

    public static void moverDerecha() {
        if (columnaActual < COLUMNAS - 1) {
            columnaActual++;
        }
    }
}