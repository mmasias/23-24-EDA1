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
        System.out.println(" > Llegó " + value);
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
            while (iterator.getNext() != null) {
                previous = iterator;
                iterator = iterator.getNext();
            }
            if (previous != null) {
                previous.setNext(null);
            } else {
                this.first = null;
            }
            System.out.println("Se fué " + iterator.getValue());
            this.size--;
        }
    }

    public void deleteFront(){
        if(this.first != null){
            System.out.println("Se fué " + this.first.getValue());
            this.first = this.first.getNext();
            this.size --;
        }
    }

    public void insertAtIndex(String value, int index){
        if (index < 0 || index > size) {
            System.out.println("----- Indice fuera de rango -----");
            return;
        }

        if (index == 0) {
            insertFront(value);
        } else if (index == size) {
            insertEnd(value);
        } else {
            Node newNode = new Node(value);
            Node iterator = this.first;
            int count = 0;
            while (count < index - 1) {
                iterator = iterator.getNext();
                count++;
            }
            newNode.setNext(iterator.getNext());
            iterator.setNext(newNode);
            this.size++;
        }
    }

    public void deleteAtIndex(int index){
        if (index < 0 || index >= size) {
            System.out.println("----- Indice fuera de rango -----");
            return;
        }

        if (index == 0) {
            deleteFront();
        } else if (index == size - 1) {
            deleteEnd();
        } else {
            Node iterator = this.first;
            int count = 0;
            while (count < index - 1) {
                iterator = iterator.getNext();
                count++;
            }
            Node nodeToDelete = iterator.getNext();
            iterator.setNext(nodeToDelete.getNext());
            System.out.println("Se fué " + nodeToDelete.getValue());
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
