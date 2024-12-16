public class HojaCalculo {
    private final int NUM_COLUMNAS = 10;
    private final int NUM_FILAS = 15;
    private final String[][] hojaCalculo = new String[NUM_FILAS][NUM_COLUMNAS];
    private int filaActual = 0;
    private int columnaActual = 0;

    public void moverArriba() {
        if (filaActual > 0) {
            filaActual--;
        }
    }

    public void moverAbajo() {
        if (filaActual < NUM_FILAS - 1) {
            filaActual++;
        }
    }

    public void moverIzquierda() {
        if (columnaActual > 0) {
            columnaActual--;
        }
    }

    public void moverDerecha() {
        if (columnaActual < NUM_COLUMNAS - 1) {
            columnaActual++;
        }
    }

    public void ingresarTexto(String contenido) {
        hojaCalculo[filaActual][columnaActual] = formatearContenido(contenido);
    }

    public void mostrarHojaDeCalculo() {
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

    public int getFilaActual() {
        return filaActual;
    }

    public int getColumnaActual() {
        return columnaActual;
    }
}
