package entregas.garcíaDiego.Ex004;

public class List {

    private Node first = null;
    private int size = 0;

    public int size() {
        return this.size;
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
        this.size++;
        System.out.println("Llega > " + value);
    }

    public void insertFirst(String value) {
        Node newNode = new Node(value);
        if (this.first == null)
            this.first = newNode;
        else {
            newNode.setNext(this.first);
            this.first = newNode;
        }
        this.size++;
        System.out.println("Llega > " + value + ", se situa el primero");
    }

    public void insertLast(String value) {
        this.insert(value);
        System.out.println(value + " se situa al final");
    }

    public void insertIn(String value, int position) {
        if (position < 0 || position > this.size())
            return;
        if (position == 0) {
            this.insertFirst(value);
            return;
        }
        if (position == this.size()) {
            this.insertLast(value);
            return;
        }
        Node newNode = new Node(value);
        Node iterator = this.first;
        int count = 0;
        while (count < position - 1) {
            iterator = iterator.getNext();
            count++;
        }
        newNode.setNext(iterator.getNext());
        iterator.setNext(newNode);
        this.size++;
        System.out.println("Llega > " + value + ", se situa en la posicion " + position);
    }

    public void delete() {
        String deletedString = null;
        if (this.first != null) {
            Node iterator = this.first;
            Node previous = null;
            while (iterator.getNext() != null) {
                previous = iterator;
                iterator = iterator.getNext();
            }
            deletedString = iterator.getValue();
            if (previous != null) {
                previous.setNext(null);
            } else {
                this.first = null;
            }
            this.size--;
        }
        System.out.println("Se fue " + deletedString);
    }

    public void deleteFirst() {
        String deletedString = null;
        if (this.first != null) {
            deletedString = this.first.getValue();
            this.first = this.first.getNext();
            this.size--;
        }
        System.out.println("Se fue " + deletedString);
    }

    public void deleteLast() {
        this.delete();
    }

    public void deleteIn(int position) {
        if (position < 0 || position > this.size())
            return;
        if (position == 0) {
            this.deleteFirst();
            return;
        }
        if (position == this.size()) {
            this.deleteLast();
            return;
        }
        Node iterator = this.first;
        Node previous = null;
        int count = 0;
        while (count < position) {
            previous = iterator;
            iterator = iterator.getNext();
            count++;
        }
        previous.setNext(iterator.getNext());
        this.size--;
        System.out.println("Se fue " + iterator.getValue() + ", estaba en la posicion " + position);
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
