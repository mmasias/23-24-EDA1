public class List {

    private Node first = null;
    private int size = 0;

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public String insert(String value) {
        Node nodoQueEntra = new Node(value);
        if (this.first == null) {
            this.first = nodoQueEntra;
        } else {
            Node iterator = this.first;
            while (iterator.getNext() != null) {
                iterator = iterator.getNext();
            }
            iterator.setNext(nodoQueEntra);
        }
        this.size++; 
        return value;
    }

    public String delete() {
        String removedValue = null;
        if (this.first != null) {
            Node iterator = this.first;
            Node previous = null;
            while (iterator.getNext() != null) {
                previous = iterator;
                iterator = iterator.getNext();
            }
            removedValue = iterator.getValue();
            if (previous == null) { 
                this.first = null;
            } else {
                previous.setNext(null);
            }
            this.size--;
        }
        return removedValue;
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