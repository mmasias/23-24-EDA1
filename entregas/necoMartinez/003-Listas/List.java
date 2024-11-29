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
    }

    public void delete() {
        if (this.first != null) {
            Node iterator = this.first;
            Node previous = null;
            while (iterator.getNext() != null) {
                previous = iterator;
                iterator = iterator.getNext();
            }
            if (previous != null)
                previous.setNext(null);
            else
                this.first = null;
        }
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
