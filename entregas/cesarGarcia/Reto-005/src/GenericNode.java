public class GenericNode<T> {
    private T value;
    private GenericNode<T> next;

    public GenericNode(T value) {
        this.value = value;
        this.next = null;
    }

    public T getValue() {
        return value;
    }

    public GenericNode<T> getNext() {
        return next;
    }

    public void setNext(GenericNode<T> next) {
        this.next = next;
    }
}
