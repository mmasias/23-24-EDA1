package Reto004.src;

public class List {

    private Node first = null;
    private int size = 0;
    private String[] listArray = new String[0];

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void insert(String value) {
        Node newNode = new Node(value);
        if (first == null) {
            first = newNode;
        } else {
            Node iterator = first;
            while (iterator.getNext() != null) {
                iterator = iterator.getNext();
            }
            iterator.setNext(newNode);
        }
        size++;
        updateListArray();
        System.out.println("> Llegó " + value);
    }

    public void delete() {
        if (first != null) {
            Node iterator = first;
            Node previous = null;
            while (iterator.getNext() != null) {
                previous = iterator;
                iterator = iterator.getNext();
            }
            previous.setNext(null);
            size--;
            updateListArray();
            System.out.println("Se fue " + iterator.getValue());
        }
    }

    public void insertFirst(String value) {
        Node newNode = new Node(value);
        newNode.setNext(first);
        first = newNode;
        size++;
        updateListArray();
        System.out.println("> Llegó " + value);
    }

    public void insertAtIndex(int index, String value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }

        if (index == 0) {
            insertFirst(value);
            return;
        }

        Node newNode = new Node(value);
        Node iterator = first;
        for (int i = 0; i < index - 1; i++) {
            iterator = iterator.getNext();
        }
        newNode.setNext(iterator.getNext());
        iterator.setNext(newNode);

        size++;
        updateListArray();
        System.out.println("> Llegó " + value);
    }

    public void deleteFirst() {
        if (first != null) {
            Node temp = first;
            first = first.getNext();
            temp.setNext(null);
            size--;
            updateListArray();
            System.out.println("Se fue " + temp.getValue());
        }
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }

        if (index == 0) {
            deleteFirst();
            return;
        }

        Node iterator = first;
        for (int i = 0; i < index - 1; i++) {
            iterator = iterator.getNext();
        }
        Node temp = iterator.getNext();
        iterator.setNext(temp.getNext());
        temp.setNext(null);

        size--;
        updateListArray();
        System.out.println("Se fue " + temp.getValue());
    }

    private void updateListArray() {
        listArray = new String[size];
        Node iterator = first;
        int count = 0;
        while (iterator != null) {
            listArray[count] = iterator.getValue();
            count++;
            iterator = iterator.getNext();
        }
    }

    public String[] listAll() {
        return listArray;
    }
}