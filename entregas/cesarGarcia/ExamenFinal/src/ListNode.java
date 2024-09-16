public class ListNode<T> {

    private T value;
    private ListNode<T> next;

    public ListNode(T value) {
        this.setValue(value);
    }

    public T getValue() {
        return value;
    }

    public void setValue(T newValue) {
        this.value = newValue;
    }

    public ListNode<T> getNext() {
        return next;
    }

    public void setNext(ListNode<T> siguiente) {
        this.next = siguiente;
    }
}