import java.util.Random;

class Customer {
    private int itemsInCart;

    public Customer() {
        itemsInCart = new Random().nextInt(11) + 5;
    }

    public int getItemsInCart() {
        return itemsInCart;
    }
}