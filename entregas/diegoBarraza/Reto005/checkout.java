package Reto005;


class checkout {
    private int itemsBeingScanned;

    public boolean isAvailable() {
        return itemsBeingScanned <= 0;
    }

    public void serveCustomer(customer customer) {
        itemsBeingScanned = customer.getItemsInCart();
    }

    public void processItem() {
        if (itemsBeingScanned > 0) {
            itemsBeingScanned--;
        }
    }
}
