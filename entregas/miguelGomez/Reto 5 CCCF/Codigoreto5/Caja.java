package Codigoreto5;
import java.util.Random;

public class Caja {
    private int items;

    public Caja() {
        items = 0;
    }

    public boolean estaDisponible() {
        return items <= 0;
    }

    public void atenderCliente() {
        items--;
    }

    public void agregarCliente() {
        items = new Random().nextInt(11) + 5;
    }

    public int getItems() {
        return items;
    }
}
