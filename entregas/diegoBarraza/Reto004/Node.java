package Reto004;

public class Node {
    private String value;
    private Reto003.Node next;

    public Node(String value) {
        this.setValue(value);
        this.setNext(null);

    }

    public String getValue() {
        return value;
    }

    public void setValue(String newValue) {
        this.value = newValue;
    }

    public Reto003.Node getNext() {
        return next;
    }

    public void setNext(Reto003.Node next) {
        this.next = next;
    }

}

