package structure;

public class JavaList<T> {
    public ListNode<T> firstNode;

    public JavaList(){
        this.firstNode = null;
    }

    public void addNode(T data){
        ListNode<T> nuevoNodo = new ListNode<>(data);

        if (firstNode == null) {
            firstNode = nuevoNodo;
        } else {
            ListNode<T> x = firstNode;
            while (x.nextNode != null) {
                x = x.nextNode;
            }
            x.nextNode = nuevoNodo;
        }
    }

    public void show() {
        ListNode<T> x = firstNode;
        while (x != null) {
            System.out.print(x.data + " ");
            x = x.nextNode;
        }
        System.out.println();
    }


    public ListNode<T> getNode(int index) {
        ListNode<T> current = firstNode;
        int currentIndex = 0;

        while (current != null && currentIndex < index) {
            current = current.nextNode;
            currentIndex++;
        }

        return current;
    }

}
