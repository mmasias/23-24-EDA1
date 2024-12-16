package entregas.garcíaDiego.Ex005;

public class Checkout {
    private Customer currentCustomer;
    private final int checkoutNumber;
    private static int checkoutCount = 0;

    public Checkout() {
        this.checkoutNumber = ++checkoutCount;
    }


    public boolean isAvailable() {
        return currentCustomer == null || currentCustomer.getItems() == 0;
    }

    public void setCustomer(Customer customer) {
        this.currentCustomer = customer;
    }

    public int getCustomer() {
        return currentCustomer.getItems();
    }

    public void processOneMinute() {
        if (currentCustomer != null) {
            currentCustomer.processItem();
            System.out.println(" --> Customer has " + currentCustomer.getItems() + " items left");
            if (currentCustomer.getItems() == 0) {
                currentCustomer = null;
            }
        }

    }

    public String toString() {
        return "Checkout " + checkoutNumber;
    }

}