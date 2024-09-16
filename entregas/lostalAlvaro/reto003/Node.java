package reto003;

public class Node {

    private String value;
    private Node next;

    public Node(int value) {
        this.setValue(String.valueOf(value));
    }

    public String getValue() {
        return value;
    }

    public void setValue(String newValue) {
        this.value = newValue;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}