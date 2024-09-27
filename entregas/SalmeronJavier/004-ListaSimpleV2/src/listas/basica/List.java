package listas.basica;

public class List {
    private Node first = null;
    private int count = 0;

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void insert(String value) {
        Node newNode = new Node(value);
        System.out.println(" > Llegó " + value + " (al final)");
        if (this.first == null) {
            this.first = newNode;
        } else {
            Node iterator = this.first;
            while (iterator.getNext() != null) {
                iterator = iterator.getNext();
            }
            iterator.setNext(newNode);
        }
        count++;
    }

    public void delete() {
        if (this.first != null) {
            Node iterator = this.first;
            Node previous = null;
            while (iterator.getNext() != null) {
                previous = iterator;
                iterator = iterator.getNext();
            }
            System.out.println(" < Se fue " + iterator.getValue() + " (del final)");
            if (previous == null) {
                this.first = null;
            } else {
                previous.setNext(null);
            }
            count--;
        } else {
            System.out.println("La lista está vacía");
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

    public void insertAtStart(String value) {
        Node newNode = new Node(value);
        System.out.println(" > Llegó " + value + " al inicio");
        newNode.setNext(this.first);
        this.first = newNode;
        count++;
    }

    public void insertAtIndex(String value, int index) {
        if (index < 0 || index > count) {
            System.out.println("Índice fuera de rango");
            return;
        }
        if (index == 0) {
            insertAtStart(value);
        } else {
            Node newNode = new Node(value);
            Node iterator = this.first;
            for (int i = 0; i < index - 1; i++) {
                iterator = iterator.getNext();
            }
            System.out.println(" > Llegó " + value + " en la posición " + index);
            newNode.setNext(iterator.getNext());
            iterator.setNext(newNode);
            count++;
        }
    }

    public void deleteFromStart() {
        if (this.first != null) {
            System.out.println(" < Se fue " + this.first.getValue() + " del inicio");
            this.first = this.first.getNext();
            count--;
        } else {
            System.out.println("La lista está vacía");
        }
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= count) {
            System.out.println("Índice fuera de rango");
            return;
        }
        if (index == 0) {
            deleteFromStart();
        } else {
            Node iterator = this.first;
            System.out.println(" < Se fue " + iterator.getNext().getValue() + " de la posición " + index);
            for (int i = 0; i < index - 1; i++) {
                iterator = iterator.getNext();
            }
            iterator.setNext(iterator.getNext().getNext());
            count--;
        }
    }
}
