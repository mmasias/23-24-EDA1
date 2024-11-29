package entregas.garciaLydia.reto003.ListaSimple;

public class List {
    private Node first = null;
    private String lastRemoved;

    public int size() {
        if (this.first == null) {
            return 0;
        }
        int count = 1;
        Node iterator = first;
        while (iterator.getNext() != null) {
            count++;
            iterator = iterator.getNext();
        }
        return count;
    }

    public boolean isEmpty() {
        return this.size() <= 0;
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
    }

    public void delete() {
        if (this.first != null) {
            Node iterator = this.first;
            Node previous = null;
            while (iterator.getNext() != null) {
                previous = iterator;
                iterator = iterator.getNext();
            }
            previous.setNext(null);
            this.lastRemoved = iterator.getValue();
        }
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

    public String getLastRemoved() {
        return this.lastRemoved;
    }
}



