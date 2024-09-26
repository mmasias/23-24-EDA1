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
        System.out.println("Entró " + value + " al final");
    }

    public void insertFront(String value) {
        Node newNode = new Node(value);
        newNode.setNext(this.first);
        this.first = newNode;
        size++; // Actualizar el tamaño
        System.out.println("Entró " + value + " al inicio");
    }

    public void insertAt(int index, String value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        if (index == 0) {
            insertFront(value);
        } else if (index == size) {
            insertEnd(value);
        } else {
            Node newNode = new Node(value);
            Node iterator = this.first;
            for (int i = 0; i < index - 1; i++) {
                iterator = iterator.getNext();
            }
            newNode.setNext(iterator.getNext());
            iterator.setNext(newNode);
            size++;
            System.out.println("Entró " + value + " en la posición " + index);
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
            if (previous != null) {
                previous.setNext(null);
            } else {
                this.first = null;
            }
            size--; // Actualizar el tamaño
            System.out.println("Salió " + iterator.getValue() + " desde el final");
        }
    }

    public void deleteFront() {
        if (this.first != null) {
            Node temp = this.first;
            this.first = this.first.getNext();
            size--;
            System.out.println("Salió " + temp.getValue() + " desde el inicio");
        }
    }

    public void deleteAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        if (index == 0) {
            deleteFront();
        } else {
            Node iterator = this.first;
            for (int i = 0; i < index - 1; i++) {
                iterator = iterator.getNext();
            }
            Node temp = iterator.getNext();
            iterator.setNext(temp.getNext());
            size--;
            System.out.println("Salió " + temp.getValue() + " desde la posición " + index);
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
