package entregas.garciaLydia.reto004.ListaSimpleV2;

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
        return this.size() == 0;
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

    public void insertFront(String value) {
        Node newNode = new Node(value);
        newNode.setNext(this.first);
        this.first = newNode;
    }

    public void deleteEnd() {
        if (this.first != null) {
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
            this.lastRemoved = iterator.getValue();
        }
    }

    public void deleteFront() {
        if (this.first != null) {
            this.first = this.first.getNext();
        }
    }

    public void insertAtIndex(int index, String value) {
        if (index < 0 || index > this.size()) {
            System.out.println("Índice fuera de rango.");
            return;
        }
        Node newNode = new Node(value);
        if (index == 0) {
            newNode.setNext(this.first);
            this.first = newNode;
        } else {
            Node iterator = this.first;
            for (int i = 0; i < index - 1; i++) {
                iterator = iterator.getNext();
            }
            newNode.setNext(iterator.getNext());
            iterator.setNext(newNode);
        }
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= this.size()) {
            System.out.println("Índice fuera de rango.");
            return;
        }
        if (index == 0) {
            this.first = this.first.getNext();
        } else {
            Node iterator = this.first;
            for (int i = 0; i < index - 1; i++) {
                iterator = iterator.getNext();
            }
            iterator.setNext(iterator.getNext().getNext());
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
