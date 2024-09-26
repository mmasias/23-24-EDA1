package miJava;

public class Celda {
    private int x;
    private int y;
    private String valor;

    public Celda(int x, int y) {
        this.x = x;
        this.y = y;
        this.valor = "       ";
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return valor;
    }

    public boolean esCeldaActual(int posX, int posY) {
        return this.x == posX && this.y == posY;
    }
}
