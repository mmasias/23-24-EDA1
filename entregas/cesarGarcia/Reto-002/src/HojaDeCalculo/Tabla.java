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

        for (int i = 0; i < filas; i++) {

            String numeroFila = String.format("%2d", i + 1);

            System.out.print(numeroFila + " |");
            for (int j = 0; j < columnas; j++) {
                String contenido = "";
                if (j < matriz[i].length) {
                    contenido = matriz[i][j].getContenido();
                }

                contenido = String.format("%-7s", contenido);

                System.out.print(" " + contenido + " |");
            }
            System.out.println();
        }
    }

    public String getPosicionActual() {
        return "Fila " + (filaActual + 1) + ", Columna " + (char) ('A' + columnaActual);
    }

    public void moverArriba() {
        if (filaActual > 0) {
            filaActual--;
        }
    }

    public void moverAbajo() {
        if (filaActual < filas - 1) {
            filaActual++;
        }
    }

    public void moverIzquierda() {
        if (columnaActual > 0) {
            columnaActual--;
        }
    }

    public void moverDerecha() {
        if (columnaActual < columnas - 1) {
            columnaActual++;
        }
    }

    public void agregarTexto(String texto) {
        if (texto.length() > 7) {
            texto = texto.substring(0, 7);
        } else {
            texto = String.format("%-7s", texto);
        }

        matriz[filaActual][columnaActual].setContenido(texto);
    }
}