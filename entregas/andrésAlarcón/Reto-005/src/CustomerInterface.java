interface CustomerInterface {
  int getItemsLength();

  void reduceItemsSize();

  CustomerInterface getNext();

  void setNext(CustomerInterface customer);
}
