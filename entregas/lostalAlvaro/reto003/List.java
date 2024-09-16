package reto003;

public class List {

    private Node first = null;

    public int size() {
        if (this.first == null) {
            return 0;
        } else {
            int count = 1;
            Node iterator = first;
            while (iterator.getNext() != null) {
                count++;
                iterator = iterator.getNext();
            }
            return count;
        }
    }

    public boolean isEmpty() {
        return this.size() > 0 ? false : true;
    }

    public void insert(String value) {
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
        System.out.println(" > Llegó " + value);
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
                System.out.println("Se fue " + iterator.getValue());
            } else {
                // Only one element in the list
                this.first = null;
                System.out.println("Se fue " + iterator.getValue());
            }
        }
    }

    public void printArrivalMessages() {
        Node iterator = this.first;
        while (iterator != null) {
            System.out.println(" > Llegó " + iterator.getValue());
            iterator = iterator.getNext();
        }
    }

    public void printList() {
        String[] list = this.listAll();
        for (String sobrino : list) {
            System.out.println(sobrino);
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
}