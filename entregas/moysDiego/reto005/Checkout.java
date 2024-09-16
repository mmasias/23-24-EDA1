class Checkout {
    private int itemsBeingScanned;

    public boolean isAvailable() {
        return itemsBeingScanned <= 0;
    }

    public void serveCustomer(Customer customer) {
        itemsBeingScanned = customer.getItemsInCart();
    }

    public void processItem() {
        if (itemsBeingScanned > 0) {
            itemsBeingScanned--;
        }
    }

    public int getItemsBeingScanned() {
        return itemsBeingScanned;
    }
}
