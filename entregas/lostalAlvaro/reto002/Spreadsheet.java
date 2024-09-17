package reto002;

import java.util.Scanner;
class Spreadsheet {
    private Cell[][] matriz;
    private int filas;
    private int columnas;
    private int filaActual;
    private int columnaActual;

    public Spreadsheet(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.matriz = new Cell[filas][columnas];
        this.filaActual = 0;
        this.columnaActual = 0;
        inicializarMatriz();
    }

    private void inicializarMatriz() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = new Cell();
            }
        }
    }

    public void imprimir() {
        for (int i = 0; i < filas; i++) {
            if (i < 9) {
                System.out.print(" " + (i + 1));
            } else {
                System.out.print((i + 1));
            }

            for (int j = 0; j < columnas; j++) {
                boolean borde = (i == filaActual && j == columnaActual);
                matriz[i][j].imprimir(borde);
            }
            System.out.println("|");
        }
        System.out.println("x: " + (filaActual + 1) + " | y:" + (columnaActual + 1));
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

    public void editarCelda() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un valor");
        String valor = sc.nextLine();
        matriz[filaActual][columnaActual].setValor(valor);
    }
}