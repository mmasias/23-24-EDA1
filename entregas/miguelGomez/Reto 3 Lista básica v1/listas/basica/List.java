package listas.basica;

public class List {

    private Node first = null;
    private int size = 0;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void insertEnd(String value) {
        Node newNode = new Node(value);
        if (this.first == null) {
            this.first = newNode;
        } else {
            Node iterator = this.first;
            while (iterator.getNext() != null) {
                iterator = iterator.getNext();
            }
            iterator.setNext(newNode);
        }
        size++; // Actualizar el tamaño
        System.out.println("Entró " + value);
    }

    public void insertFront(String value) {
        Node newNode = new Node(value);
        newNode.setNext(this.first);
        this.first = newNode;
        size++; // Actualizar el tamaño
        System.out.println("Entró " + value);
    }

    public void delete() {
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
            size--; // Actualizar el tamaño
            System.out.println("Salió " + iterator.getValue());
        }
    }

    public String[] listAll() {
        String[] list = new String[size];
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
