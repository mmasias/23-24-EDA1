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

    public void insert(String value) {
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

    public void delete() {
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
