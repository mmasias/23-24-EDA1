import java.util.Scanner;

public class Reto001HojaDeCalculo{
    public static void main(String[] args) {
        int filas = 15;
        int columnas = 10;
        int filaActual = 0;
        int columnaActual = 0;
        String[][] hoja = new String[filas][columnas];
        Scanner scanner = new Scanner(System.in);

        
        hoja = InicializarHoja(hoja, filas, columnas, filaActual, columnaActual, scanner);
        

        while (true) {
            imprimirHoja(hoja);

            System.out.println("Celda Actual: " + convertirCoordenadas(columnaActual) + (filaActual + 1));
            instrucciones();
            String accion = scanner.nextLine().toLowerCase();

            if (accion.equals("q")) {
                break;
            } else if (accion.equals("e")) {
                System.out.print("Introduce el contenido de la celda: ");
                String valor = scanner.nextLine();
                hoja[filaActual][columnaActual] = String.format("%-7s", valor).substring(0, 7);
            } else if (accion.equals("w") || accion.equals("s")) {
                int[] nuevaPosicion = moverVertical(accion, filaActual, filas);
                filaActual = nuevaPosicion[0];
            } else if (accion.equals("a") || accion.equals("d")) {
                int[] nuevaPosicion = moverHorizontal(accion, columnaActual, columnas);
                columnaActual = nuevaPosicion[0];
            }
        }

        System.out.println("Hasta luego.");
    }

    public static void instrucciones(){
        System.out.println("Navegación: w/a/s/d, Ingresar valor: e, Terminar: q");
            System.out.println("Instrucciones: Use w/a/s/d para moverse, e para ingresar un valor, q para salir.");
            System.out.print("Ingrese un comando: ");
    } 

    public static String[][] InicializarHoja(String[][] hoja, int filas, int columnas, int filaActual, int columnaActual, Scanner scanner){
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                hoja[i][j] = "       ";
            }
        }
        return hoja;
    }

    public static void imprimirHoja(String[][] hoja) {
        System.out.print("     ");
        for (int i = 0; i < hoja[0].length; i++) {
            System.out.print("  " + (char) ('A' + i) + "     ");
        }
        System.out.println();
        System.out.println("   ---------------------------------------------------------------------------------");

        for (int i = 0; i < hoja.length; i++) {
            System.out.print(i+1);
            if (i+1 < 10) {
                System.out.print("  |");
            } else {
                System.out.print(" |");
            }
            for (String celda : hoja[i]) {
                System.out.print(celda + "|");
            }
            System.out.println();
            System.out.println("   ---------------------------------------------------------------------------------");
        }
    }

    public static String convertirCoordenadas(int columna) {
        char letra = (char) ('A' + columna);
        return String.valueOf(letra);
    }

    public static int[] moverVertical(String direccion, int filaActual, int filas) {
        int nuevaFila = filaActual;
        if (direccion.equals("w") && filaActual > 0) {
            nuevaFila--;
        } else if (direccion.equals("s") && filaActual < filas - 1) {
            nuevaFila++;
        }
        return new int[] { nuevaFila, filaActual };
    }

    public static int[] moverHorizontal(String direccion, int columnaActual, int columnas) {
        int nuevaColumna = columnaActual;
        if (direccion.equals("a") && columnaActual > 0) {
            nuevaColumna--;
        } else if (direccion.equals("d") && columnaActual < columnas - 1) {
            nuevaColumna++;
        }
        return new int[] { nuevaColumna, columnaActual };
    }
    
}