public class List {

    private Node first = null;
    private int size = 0;

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public String insertFirst(String value) {
        Node newNode = new Node(value);
        newNode.setNext(first);
        first = newNode;
        size++;
        return value;
    }

    public String insertLast(String value) {
        return insert(value);
    }

    public String insertAt(String value, int index) {
        if (index == 0) {
            return insertFirst(value);
        } else if (index == size) {
            return insertLast(value);
        } else if (index > 0 && index < size) {
            Node newNode = new Node(value);
            Node iterator = first;
            for (int i = 0; i < index - 1; i++) {
                iterator = iterator.getNext();
            }
            newNode.setNext(iterator.getNext());
            iterator.setNext(newNode);
            size++;
            return value;
        }
        return null;
    }

    public String deleteFirst() {
        if (first != null) {
            String removedValue = first.getValue();
            first = first.getNext();
            size--;
            return removedValue;
        }
        return null;
    }

    public String deleteLast() {
        return delete(); 
    }

    public String deleteAt(int index) {
        if (index == 0) {
            return deleteFirst();
        } else if (index == size - 1) {
            return deleteLast();
        } else if (index > 0 && index < size - 1) {
            Node iterator = first;
            for (int i = 0; i < index - 1; i++) {
                iterator = iterator.getNext();
            }
            String removedValue = iterator.getNext().getValue();
            iterator.setNext(iterator.getNext().getNext());
            size--;
            return removedValue;
        }
        return null;
    }

    public String insert(String value) {
        Node incomingNode = new Node(value);
        if (this.first == null) {
            this.first = incomingNode;
        } else {
            Node iterator = this.first;
            while (iterator.getNext() != null) {
                iterator = iterator.getNext();
            }
            iterator.setNext(incomingNode);
        }
        this.size++; 
        return value;
    }

    public String delete() {
        String removedValue = null;
        if (this.first != null) {
            Node iterator = this.first;
            Node previous = null;
            while (iterator.getNext() != null) {
                previous = iterator;
                iterator = iterator.getNext();
            }
            removedValue = iterator.getValue();
            if (previous == null) { 
                this.first = null;
            } else {
                previous.setNext(null);
            }
            this.size--;
        }
        return removedValue;
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