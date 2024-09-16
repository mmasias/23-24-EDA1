public class List<T> {
    private GenericNode<T> head;
    private int size;

    public List() {
        head = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void insert(T value) {
        GenericNode<T> newNode = new GenericNode<>(value);
        if (head == null) {
            head = newNode;
        } else {
            GenericNode<T> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        size++;
    }

    public void delete() {
        if (head != null) {
            head = head.getNext();
            size--;
        }
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        GenericNode<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getValue();
    }

    public String[] listAll() {
        String[] items = new String[size];
        GenericNode<T> current = head;
        for (int i = 0; i < size; i++) {
            items[i] = current.getValue().toString();
            current = current.getNext();
        }
        return items;
    }
}
