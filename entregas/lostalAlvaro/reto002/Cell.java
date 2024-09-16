package reto002;

class Cell {
    private String valor;

    public Cell() {
        this.valor = " ";
    }

    public void imprimir(boolean borde) {
        final int ANCHO_DE_CELDA = 7;
        String celda = valor;

        if (valor.length() < ANCHO_DE_CELDA) {
            celda = " ".repeat(ANCHO_DE_CELDA - valor.length()) + valor;
        } else {
            celda = celda.substring(celda.length() - ANCHO_DE_CELDA);
        }

        if (borde) {
            celda = "[" + celda + "]";
        }

        System.out.print("|" + celda);
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}