package Reto005;
import java.util.Random;

public class customer {private int itemsInCart;
    public static final double ARRIVAL_PROBABILITY = 0.4;

    public customer() {
        itemsInCart = new Random().nextInt(11) + 5;
    }

    public int getItemsInCart() {
        return itemsInCart;
    }
}
