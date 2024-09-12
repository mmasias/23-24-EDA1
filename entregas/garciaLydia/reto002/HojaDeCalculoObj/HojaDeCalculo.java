package entregas.garciaLydia.reto002.HojaDeCalculoObj;

public class HojaDeCalculo {
    private static int FILAS;
    private static int COLUMNAS;
    private static int filaActual = 0;
    private static int columnaActual = 0;
    private boolean modoEdicion = false;
    private static String[][] hoja;

    public HojaDeCalculo(int filas, int columnas) {
        FILAS = filas;
        COLUMNAS = columnas;
        hoja = new String[FILAS][COLUMNAS];
        inicializarHoja();
    }

    private void inicializarHoja() {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                hoja[i][j] = "";
            }
        }
    }

    public int getFilaActual() {
        return filaActual;
    }

    public void setFilaActual(int filaActual) {
        HojaDeCalculo.filaActual = filaActual;
    }

    public int getColumnaActual() {
        return columnaActual;
    }

    public void setColumnaActual(int columnaActual) {
        HojaDeCalculo.columnaActual = columnaActual;
    }

    public boolean isModoEdicion() {
        return modoEdicion;
    }

    public void setModoEdicion(boolean modoEdicion) {
        this.modoEdicion = modoEdicion;
    }

    public String getCelda(int fila, int columna) {
        return hoja[fila][columna];
    }

    public void setCelda(int fila, int columna, String valor) {
        if (modoEdicion) {
            hoja[fila][columna] = valor;
        }
    }

    public static void imprimir() {
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

    public void moverArriba() {
        if (filaActual > 0) {
            filaActual--;
        }
    }

    public void moverAbajo() {
        if (filaActual < FILAS - 1) {
            filaActual++;
        }
    }

    public void moverIzquierda() {
        if (columnaActual > 0) {
            columnaActual--;
        }
    }

    public void moverDerecha() {
        if (columnaActual < COLUMNAS - 1) {
            columnaActual++;
        }
    }
}

