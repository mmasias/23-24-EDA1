public class Queue {

    private Client first = null;

    private int size;

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void arrives() {
        Client newClient = new Client();
        if (this.first == null)
            this.first = newClient;
        else {
            Client iterator = this.first;
            while (iterator.getNext() != null) {
                iterator = iterator.getNext();
            }
            iterator.setNext(newClient);
        }
        this.size++;
        System.out.println(" > Llegó un cliente con " + newClient.getItemPacks() + " items");
    }

    public int attend() {
        int itemsToRegister = this.first.getItemPacks();
        this.first = this.first.getNext();
        this.size--;
        return itemsToRegister;
    }
}



