package HojaDeCalculo;

public class Tabla {
    private Celda[][] matriz;
    private int filas;
    private int columnas;
    private int filaActual;
    private int columnaActual;

    public Tabla(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.matriz = new Celda[filas][columnas];
        inicializarMatriz();
    }

    private void inicializarMatriz() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = new Celda();
            }
        }
    }

    public void imprimirHoja() {

    }

    public String getPosicionActual() {

        return null;
    }

    public void moverArriba() {

    }

    public void moverAbajo() {

    }

    public void moverIzquierda() {

    }

    public void moverDerecha() {

    }

    public void agregarTexto(String texto) {

    }
}

