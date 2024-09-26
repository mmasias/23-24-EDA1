package entregas.garcíaDiego.Ex005;
public class QueueManager {
    private GenericList<Customer> queue = new GenericList<>();

    public void addCustomerToQueue(Customer customer) {
        queue.insertEnd(customer);
    }

    public Customer getNextCustomer() {
        if (!queue.isEmpty()) {
            Customer nextCustomer = queue.getFirst().getValue();
            queue.deleteFront();
            return nextCustomer;
        }
        return null;
    }

    public int getQueueSize() {
        return queue.size();
    }

    public boolean isEmpty() {
        if (queue.size() == 0) {
            return true;
        }
        return false;
    }
}