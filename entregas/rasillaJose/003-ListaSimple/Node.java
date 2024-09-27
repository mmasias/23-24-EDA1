public class Node {

    private String value;
    private Node next;
    private boolean isLast = true;


    public boolean getisLast(){
        return isLast;
    }


    public Node(String value) {
        this.setValue(value);
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
        isLast = false;
    }
}
