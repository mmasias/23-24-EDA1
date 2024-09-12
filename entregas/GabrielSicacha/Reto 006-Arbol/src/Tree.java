import java.util.LinkedList;
import java.util.Queue;

public class Tree {
    Node root;

    public Tree() {
        this.root = null;
    }

    public void insert(int value) {
        this.root = insertRecursive(this.root, value);
    }

    private Node insertRecursive(Node current, int value) {

        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            current.leftChild = insertRecursive(current.leftChild, value);
        } else if (value > current.value) {
            current.rightChild = insertRecursive(current.rightChild, value);
        }

        return current;
    }

    public void traverseInOrder() {
        traverseInOrderRecursive(this.root);
        System.out.println();
    }

    private void traverseInOrderRecursive(Node current) {
        if (current != null) {
            traverseInOrderRecursive(current.leftChild);
            System.out.print(current.value + " ");
            traverseInOrderRecursive(current.rightChild);
        }
    }

    public void traversePreOrder() {
        traversePreOrderRecursive(this.root);
        System.out.println();
    }

    private void traversePreOrderRecursive(Node current) {
        if (current != null) {
            System.out.print(current.value + " ");
            traversePreOrderRecursive(current.leftChild);
            traversePreOrderRecursive(current.rightChild);
        }
    }

    public void traversePostOrder() {
        traversePostOrderRecursive(this.root);
        System.out.println();
    }

    private void traversePostOrderRecursive(Node current) {
        if (current != null) {
            traversePostOrderRecursive(current.leftChild);
            traversePostOrderRecursive(current.rightChild);
            System.out.print(current.value + " ");
        }
    }

    public void breadthFirstTraversal() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.value + " ");

            if (current.leftChild != null) {
                queue.add(current.leftChild);
            }

            if (current.rightChild != null) {
                queue.add(current.rightChild);
            }
        }
    }
}