package structure;

public class ListNode<T> {
    public T data;
    public ListNode<T> nextNode;

    public ListNode(T data){
        this.data = data;
        this.nextNode = null;
    }
}
