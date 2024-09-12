package ProyectoFinal;

public class List<T> {
    private Node<T> head;

    public List() {
        this.head = null;
    }

    public Node<T> getHead() {
        return head;
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }

    public T getFirst() {
        if (head != null) {
            return head.getData();
        } else {
            return null; // o manejar de otra manera
        }
    }
}
