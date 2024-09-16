package src;

import java.util.Random;

public class Persona {
    private int items;

    public Persona() {
        items = new Random().nextInt(7) + 5;
    }

    public int getItems() {
        return items;
    }

    public void atenderItem() {
        if (items > 0) {
            items--;
        }
    }

    public boolean tieneItems() {
        return items > 0;
    }
}