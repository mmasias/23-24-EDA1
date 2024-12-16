import java.util.Scanner;

public class VisiCalc {
    public static void main(String[] args) {
        final int NUM_COLUMNAS = 10;
        final int NUM_FILAS = 15;
        final int LONGITUD_MAXIMA = 6;

        String[][] hojaCalculo = new String[NUM_FILAS][NUM_COLUMNAS];
        int filaActual = 0;
        int columnaActual = 0;

        Scanner entrada = new Scanner(System.in);
        char inputUsuario;
        boolean terminar = false;

        do {
            System.out.println("cmdS: [W]Arriba, [S]Abajo, [A]Izquierda, [D]Derecha, [F]Salir, [E]Ingresar Texto");
            System.out.println("Ingrese Comando: ");
            inputUsuario = entrada.nextLine().charAt(0);
            switch (inputUsuario) {
                case 'w', 'W':
                    if (filaActual > 0) {
                        filaActual--;
                    }
                    break;
                case 's', 'S':
                    if (filaActual < NUM_FILAS - 1) {
                        filaActual++;
                    }
                    break;
                case 'a', 'A':
                    if (columnaActual > 0) {
                        columnaActual--;
                    }
                    break;
                case 'd', 'D':
                    if (columnaActual < NUM_COLUMNAS - 1) {
                        columnaActual++;
                    }
                    break;
                case 'f', 'F':
                    System.out.println("Ha finalizado el programa");
                    terminar = true;
                    break;
                case 'e', 'E':
                    System.out.println("Texto o numero");
                    String contenido = entrada.nextLine();
                    hojaCalculo[filaActual][columnaActual] = formatearContenido(contenido);
                    break;
            }

            System.out.println("--- HOJA DE CALCULOS ---");
            System.out.println("| 1 |    A   |    B   |    C   |    D   |    E   |    F   |    G   |    H   |    I   |    J   |");
            mostrarHojaDeCalculo(hojaCalculo);
            System.out.println("| |X: "+(filaActual + 1+"|"+" Y: "+columnaActual+"|"));
            System.out.println("+----------------------------------------------------------------------------------------------+");
        } while (!terminar);
    }

    private static void mostrarRegleta() {
        final int NUM_COLUMNAS = 10;
        String REGLETA = "+----------------------------------------------------------------------------------------------+";
        System.out.println(REGLETA);

        for(char columna = 'A'; columna < 'A' + NUM_COLUMNAS; columna++) {
            System.out.println(" "+ columna);
        }
        System.out.println();
    }

    private static String formatearContenido(String contenido) {
        final int LONGITUD_MAXIMA = 6;
        if (contenido.length() > LONGITUD_MAXIMA) {
            return contenido.substring(0, LONGITUD_MAXIMA);
        } else {
            StringBuilder sb = new StringBuilder(contenido);
            while (sb.length() < LONGITUD_MAXIMA) {
                sb.insert(0, " ");
            }
            return sb.toString();
        }
    }

    private static void mostrarHojaDeCalculo(String[][] hojaCalculo) {
        final int NUM_FILAS = hojaCalculo.length;
        final int NUM_COLUMNAS = hojaCalculo[0].length;
        String REGLETA = "+----------------------------------------------------------------------------------------------+";
        System.out.println(REGLETA);

        for (int fila = 0; fila < NUM_FILAS; fila++) {
            System.out.print("| " + (fila + 1) + " |");
            for (int columna = 0; columna < NUM_COLUMNAS; columna++) {
                String contenido = hojaCalculo[fila][columna];
                if (contenido == null) {
                    contenido = "";
                }
                System.out.print(" " + formatearContenido(contenido) + " |");
            }
            System.out.println();
        }

        System.out.println(REGLETA);
    }
}