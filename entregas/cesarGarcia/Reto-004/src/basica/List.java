package basica;

class List {
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
        return this.size() == 0;
    }

    public void insert(String value) {
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
        System.out.println("Entró " + value);
    }

    public void insertAtBeginning(String value) {
        Node newNode = new Node(value);
        newNode.setNext(this.first);
        this.first = newNode;
    }

    public String delete() {
        if (this.first != null) {
            Node iterator = this.first;
            Node previous = null;
            while (iterator.getNext() != null) {
                previous = iterator;
                iterator = iterator.getNext();
            }
            if (previous != null) {
                previous.setNext(null);
            } else {
                this.first = null;
            }
            return iterator.getValue();
        }
        return null;
    }

    public String deleteFromBeginning() {
        if (this.first != null) {
            Node deletedNode = this.first;
            this.first = this.first.getNext();
            return deletedNode.getValue();
        }
        return null;
    }

    public String deleteFromEnd() {
        if (this.first == null) {
            return null;
        }

        if (this.first.getNext() == null) {
            // Caso especial: solo hay un elemento en la lista
            Node deletedNode = this.first;
            this.first = null;
            return deletedNode.getValue();
        }

        Node iterator = this.first;
        Node previous = null;
        while (iterator.getNext() != null) {
            previous = iterator;
            iterator = iterator.getNext();
        }
        previous.setNext(null);
        return iterator.getValue();
    }

    public void insertAtIndex(String value, int index) {
        if (index < 0 || index > this.size()) {
            // Manejar un índice fuera de rango
            return;
        }
        if (index == 0) {
            insertAtBeginning(value);
        } else {
            Node newNode = new Node(value);
            Node iterator = this.first;
            for (int i = 0; i < index - 1; i++) {
                iterator = iterator.getNext();
            }
            newNode.setNext(iterator.getNext());
            iterator.setNext(newNode);
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
