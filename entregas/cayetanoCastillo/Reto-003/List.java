package Reto003;

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
