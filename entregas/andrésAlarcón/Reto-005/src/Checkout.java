public class Checkout implements CheckoutInterface {
  private CustomerInterface actualCustomer = null;
  private boolean isEmpty = true;

  public void receiveCustomer(CustomerInterface newCustomer) {
    this.actualCustomer = newCustomer;
    this.isEmpty = false;
  }

  public void chargeItem() {
    actualCustomer.reduceItemsSize();
    if (actualCustomer.getItemsLength() == 0) {
      setFree();
    }
  }

  public void setFree() {
    actualCustomer = null;
    isEmpty = true;
  }

  public boolean isEmpty() {
    return isEmpty;
  }

  public void printRemainingItems() {
    System.out.println("Items remaining [" + (actualCustomer != null ? actualCustomer.getItemsLength() : 0) + "]");
  }
}
