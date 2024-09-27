public class List<T> {
    private Node<T> head;
    private int size;

    public List() {
        this.head = null;
        this.size = 0;
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data, size + 1);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        size++;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getData();
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }

        if (index == 0) {
            head = head.getNext();
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            current.setNext(current.getNext().getNext());
        }
        size--;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public boolean contains(T data) {
        Node<T> current = head;
        while (current != null) {
            if (current.getData().equals(data)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public Node<T> getHead() {
        return head;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> current = head;
        while (current != null) {
            sb.append(current.getData().toString());
            if (current.getNext() != null) {
                sb.append(" -> ");
            }
            current = current.getNext();
        }
        return sb.toString();
    }
}