public class HojaCalculo {
    private int filas;
    private int columnas;
    private Celda[][] hoja;

    public HojaCalculo(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        hoja = new Celda[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                hoja[i][j] = new Celda();
            }
        }
    }

    public Celda obtenerCelda(int fila, int columna) {
        if (fila >= 0 && fila < filas && columna >= 0 && columna < columnas) {
            return hoja[fila][columna];
        } else {
            // Si la celda está fuera de los límites, devolvemos una celda con contenido en blanco.
            return new Celda();
        }
    }

    public int obtenerFilas() {
        return filas;
    }

    public int obtenerColumnas() {
        return columnas;
    }
}
