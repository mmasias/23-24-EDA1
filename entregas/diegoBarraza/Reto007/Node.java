package Reto007;

public class Node<T> {
    private T data;
    private int index;
    private Node<T> next;
    private Node<T> left;
    private Node<T> right;

    public Node(T data, int index) {
        this.data = data;
        this.index = index;
        this.next = null;
        this.left = null;
        this.right = null;
    }

    public int getIndex() {
        return index;
    }

    public T getData() {
        return data;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}