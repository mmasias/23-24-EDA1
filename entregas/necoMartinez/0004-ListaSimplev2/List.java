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
        return this.size() == 0;
    }

    public void insert(String value, int position) {
        if (position < 0) {
            System.out.println("Invalid position. Element not added.");
            return;
        }

        Node newNode = new Node(value);

        if (position == 0 || this.first == null) {
            newNode.setNext(this.first);
            this.first = newNode;
        } else {
            Node iterator = this.first;
            Node previous = null;
            int index = 0;

            while (index < position && iterator != null) {
                previous = iterator;
                iterator = iterator.getNext();
                index++;
            }

            if (iterator != null) {
                previous.setNext(newNode);
                newNode.setNext(iterator);
            } else {
                // Add at the end of the list
                previous.setNext(newNode);
            }
        }
    }

    public void insertAtBeginning(String value) {
        insert(value, 0);
    }

    public void insertAtEnd(String value) {
        insert(value, size());
    }

    public void delete(int position) {
        if (position < 0 || this.first == null) {
            // Handle invalid index or empty list
            System.out.println("Invalid index or empty list. No element deleted.");
            return;
        }
        if (position == 0) {
            this.first = this.first.getNext();
        } else {
            Node iterator = this.first;
            Node previous = null;
            int index = 0;
            while (index < position && iterator != null) {
                previous = iterator;
                iterator = iterator.getNext();
                index++;
            }
            if (iterator != null) {
                previous.setNext(iterator.getNext());
            } else {
                // Handle index out of bounds
                System.out.println("Index out of bounds. No element deleted.");
            }
        }
    }

    public void deleteFromBeginning() {
        delete(0);
    }

    public void deleteFromEnd() {
        delete(size() - 1);
    }

    public void insertAtPosition(String value, int position) {
        insert(value, position);
    }

    @Override
    public String toString() {
        StringBuilder listBuilder = new StringBuilder();
        Node iterator = this.first;
        while (iterator != null) {
            listBuilder.append(iterator.toString()).append("\n");
            iterator = iterator.getNext();
        }
        return listBuilder.toString();
    }
}