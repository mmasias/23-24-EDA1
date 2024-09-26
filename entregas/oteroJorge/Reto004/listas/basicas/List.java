package listas.basica;

public class List {

    private Node first = null;

    public int size() {
        int count = 0;
        Node iterator = first;

        while (iterator != null) {
            count++;
            iterator = iterator.getNext();
        }

        return count;
    }
    public boolean isEmpty() {
        return this.size() > 0 ? false : true;
    }

    public void insertEnd(String value) {
        Node nodoQueEntra = new Node(value);
        if (this.first == null){
            this.first = nodoQueEntra;
        } else {
            Node iterator = this.first;
            while (iterator.getNext() != null) {
                iterator = iterator.getNext();
            }
            iterator.setNext(nodoQueEntra);
        }
        System.out.println("> Llegó " + value);
    }
    public void insertFront(String value) {
        Node n = new Node(value);
        if (this.first == null) {
        } else {
            n.setNext(this.first);
        }
        this.first = n;
        System.out.println("> Llegó " + value);
    }
    public void insertExactlyPosition(int position, String value){
        Node n = new Node(value);
        if (this.first == null) {
            this.first = n;
        } else {
            Node iterator = this.first;
            int count = 0;
            while (iterator.getNext() != null && count < position - 1) {
                iterator = iterator.getNext();
                count++;
            }
            n.setNext(iterator.getNext());
            iterator.setNext(n);
        }
        System.out.println("> Llegó " + value);
    }

    public void deleteEnd() {
        if (this.first == null) {
            return;
        }

        Node iterator = this.first;
        Node previous = null;

        while (iterator.getNext() != null) {
            previous = iterator;
            iterator = iterator.getNext();
        }

        if (previous == null) {
            this.first = null;
        } else {
            previous.setNext(null);
        }
        System.out.println("> Se fue " + iterator.getValue());
    }
    public void deleteFront() {
        if (this.first == null) {
            return;
        }
        Node iterator = this.first;
        this.first = iterator.getNext();
        System.out.println("> Se fue " + iterator.getValue());
    }
    public void deleteExactlyPosition(int position){
        if (this.first == null) {
            return;
        }
        Node iterator = this.first;
        Node previous = null;
        int count = 1;
        while (iterator.getNext() != null && count < position) {
            previous = iterator;
            iterator = iterator.getNext();
            count++;
        }
        if (previous == null) {
            this.first = iterator.getNext();
        } else {
            previous.setNext(iterator.getNext());
        }
        System.out.println("> Se fue " + iterator.getValue());
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
