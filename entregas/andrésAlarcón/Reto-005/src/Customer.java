public class Customer implements CustomerInterface {
  private ItemsInterface items;
  private CustomerInterface next;

  public Customer() {
    int itemsLength = (int) (Math.random() * (15 - 5) + 5);
    setItems(itemsLength);
  }

  private void setItems(int size) {
    items = new Items(size);
  }

  public void reduceItemsSize() {
    items.reduceSize();
  }

  public int getItemsLength() {
    return items.getSize();
  }

  public CustomerInterface getNext() {
    return next;
  }

  public void setNext(CustomerInterface next) {
    this.next = next;
  }
}