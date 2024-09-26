public class Queue implements QueueInterface {
    private CustomerInterface first = null;
    private int size = 0;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public CustomerInterface getFirst() {
        return first;
    }

    public void newCustomer(CustomerInterface customer) {
        if (first == null) {
            first = customer;
        } else {
            CustomerInterface iterator = first;
            while (iterator.getNext() != null) {
                iterator = iterator.getNext();
            }
            iterator.setNext(customer);
        }
        System.out.println("A person has arrived at the queue.");
        size++;
    }

    public void removeCustomer() {
        if (first != null) {
            first = first.getNext();
            size--;
        }
    }
}