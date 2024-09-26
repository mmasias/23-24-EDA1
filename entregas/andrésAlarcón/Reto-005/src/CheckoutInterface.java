interface CheckoutInterface {
    void receiveCustomer(CustomerInterface newCustomer);

    void chargeItem();

    void setFree();

    boolean isEmpty();

    void printRemainingItems();
}
