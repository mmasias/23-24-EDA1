package entregas.garcíaDiego.Ex005;

import java.util.Random;

public class Customer {
    private int items;

    public Customer() {
        this.items = new Random().nextInt(11) + 5;
    }

    public int getItems() {
        return items;
    }

    public void processItem() {
        if (items > 0) {
            items--;
        }
    }
}