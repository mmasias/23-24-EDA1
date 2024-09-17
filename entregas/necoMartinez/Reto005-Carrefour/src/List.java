public class List {
    private GenericNode head;
    private int size;

    public List() {
        this.head = null;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void insert(String value) {
        GenericNode newNode = new GenericNode(value);
        if (isEmpty()) {
            head = newNode;
        } else {
            GenericNode current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        size++;
    }

    public void delete() {
        if (!isEmpty()) {
            head = head.getNext();
            size--;
        }
    }

    public String[] listAll() {
        String[] values = new String[size];
        GenericNode current = head;
        int index = 0;
        while (current != null) {
            values[index++] = current.getValue();
            current = current.getNext();
        }
        return values;
    }
}
