public class Node<T> {
    private T data;
    private Node<T> siguiente;

    public Node(T data) {
        this.data = data;
        this.siguiente = null;
    }

    public T getData() {
        return data;
    }

    public Node<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Node<T> siguiente) {
        this.siguiente = siguiente;
    }
}