public class List {

    private Node first = null;
    private int size;

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void insertEnd(String value) {
        Node newNode = new Node(value);
        if (this.first == null)
            this.first = newNode;
        else {
            Node iterator = this.first;
            while (iterator.getNext() != null) {
                iterator = iterator.getNext();
            }
            iterator.setNext(newNode);
        }
        this.size++;
        System.out.println(" > Llegó " + value);
    }

    public void insertFront(String value) {
        Node newNode = new Node(value);
        if (this.first == null)
            this.first = newNode;
        else {
            newNode.setNext(this.first);
            this.first = newNode;
        }
        this.size++;
        System.out.println(" > Llegó " + value);
    }

    public void insertNessim(String value, int n) {
        int i = 1;
        Node newNode = new Node(value);

            Node iterator = this.first;
            while ((iterator.getNext() != null)&&( i < n-1)){
                iterator = iterator.getNext();
                i++;
            }
            Node provisional = iterator.getNext();
            iterator.setNext(newNode);
            iterator = iterator.getNext();
            iterator.setNext(provisional);

        this.size++;
        System.out.println(" > Llegó " + value);
    }

    public void deleteEnd() {
        if (this.first != null) {
            Node iterator = this.first;
            Node previous = null;
            while (iterator.getNext() != null) {
                previous = iterator;
                iterator = iterator.getNext();
            }
            System.out.println(" > Se fue " + iterator.getValue());
            this.size--;
            previous.setNext(null);
        }
    }

    public void deleteFront(){
        System.out.println(" > Se fue " + this.first.getValue());
        this.first = this.first.getNext();
        this.size--;

    }

    public String[] listAll() {
        String[] list = new String[this.size()];
        Node iterator = this.first;
        if (iterator == null)
            return list;
        int count = 0;
        while (iterator != null) {
            list[count] = iterator.getValue();
            count++;
            iterator = iterator.getNext();
        }
        return list;
    }
}
