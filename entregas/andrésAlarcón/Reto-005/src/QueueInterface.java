public interface QueueInterface {
  int size();

  boolean isEmpty();

  CustomerInterface getFirst();

  void newCustomer(CustomerInterface customer);

  void removeCustomer();
}
