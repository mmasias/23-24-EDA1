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

    public void insertAtStart(String value) {
        Node newNode = new Node(value);
        if (this.first == null) {
            this.first = newNode;
        } else {
            newNode.setNext(this.first);
            this.first = newNode;
        }
        System.out.println("> Llegó " + value);
    }

    public void insertAtEnd(String value) {
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
        System.out.println("> Llegó " + value);
    }

    public void deleteFromStart() {
        if (this.first != null) {
            System.out.println("> Se fue " + this.first.getValue());
            this.first = this.first.getNext();
        }
    }

    public void deleteFromEnd() {
        Node iterator = this.first;
        Node previous = null;
        while (iterator != null && iterator.getNext() != null) {
            previous = iterator;
            iterator = iterator.getNext();
        }
        if (previous != null) {
            previous.setNext(null);
            System.out.println("> Se fue " + iterator.getValue());
        } else if (iterator != null) {
            // If previous is null, it means there was only one element in the list.
            // In this case, set the first node to null.
            System.out.println("> Se fue " + iterator.getValue());
            this.first = null;
        }
    }
    public void insertAtIndex(String value, int index) {
        if (index < 0 || index > this.size()) {
            System.out.println("Índice fuera de rango.");
            return;
        }
        if (index == 0) {
            insertAtStart(value);
        } else if (index == this.size()) {
            insertAtEnd(value);
        } else {
            Node newNode = new Node(value);
            Node iterator = this.first;
            for (int i = 0; i < index - 1; i++) {
                iterator = iterator.getNext();
            }
            newNode.setNext(iterator.getNext());
            iterator.setNext(newNode);
            System.out.println("> Llegó " + value);
        }
    }
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= this.size()) {
            System.out.println("Índice fuera de rango.");
            return;
        }
        if (index == 0) {
            deleteFromStart();
        } else if (index == this.size() - 1) {
            deleteFromEnd();
        } else {
            Node iterator = this.first;
            for (int i = 0; i < index - 1; i++) {
                iterator = iterator.getNext();
            }
            Node deletedNode = iterator.getNext();
            iterator.setNext(deletedNode.getNext());
            System.out.println("> Se fue " + deletedNode.getValue());
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
