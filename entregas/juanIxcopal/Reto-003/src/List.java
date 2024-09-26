public class List {

    private Node first = null;

    private int size = 0;

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public void insertEnd(String value) {
        Node newNode = new Node(value);
        System.out.println(" > Llegó " + value);
        if (this.first == null) {
            this.first = newNode ;
        } else {
            Node iterator = this.first;
            while (iterator.getNext() != null) {
                iterator = iterator.getNext();
            }
            iterator.setNext(newNode);
        }
        this.size ++;
    }

    public void insertFront(String value){
        Node n = new Node(value);
        if(this.first == null){
            this.first = n;
        }
        else{
            n.setNext(this.first);
            this.first = n;
        }
    }

    public void deleteEnd() {
        if (this.first != null) {
            Node iterator = this.first;
            Node previous = null;
            System.out.println("Se fué " + iterator.getValue());
            while (iterator.getNext() != null) {
                previous = iterator;
                iterator = iterator.getNext();
            }
            previous.setNext(null);
            this.size--;
        }
    }

    public String[] listAll() {
        String[] list = new String[this.size()];
        Node iterator = this.first;
        int count = 0;
        while (iterator != null) {
            list[count] = iterator.getValue();
            count++;
            iterator = iterator.getNext();
        }
        return list;
    }
}
