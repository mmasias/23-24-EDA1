import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tree {

    private Node root;

    public Tree(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    public List<Node> inOrderTraversal() {
        List<Node> nodes = new ArrayList<>();
        inOrderTraversal(root, nodes);
        return nodes;
    }

    private void inOrderTraversal(Node node, List<Node> nodes) {
        if (node == null) {
            return;
        }

        inOrderTraversal(node.getLeft(), nodes);
        nodes.add(node);
        inOrderTraversal(node.getRight(), nodes);
    }

    public void insert(int data, int index) {
        Node newNode = new Node(data);
        if (index == 0) {
            insertFirst(newNode);
        } else if (index == -1) {
            insertLast(newNode);
        } else {
            insertAt(newNode, index);
        }
    }

    private void insertFirst(Node newNode) {
        if (root == null) {
            root = newNode;
        } else {
            newNode.setRight(root);
            root = newNode;
        }
    }

    private void insertLast(Node newNode) {
        Node last = getLast();
        last.setRight(newNode);
    }

    private void insertAt(Node newNode, int index) {
        Node current = getNodeAt(index);
        if (current == null) {
            throw new IndexOutOfBoundsException();
        }
        newNode.setRight(current.getRight());
        current.setRight(newNode);
    }

    public Node remove(int index) {
        Node removedNode = getNodeAt(index);
        if (removedNode == null) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            removeFirst();
        } else {
            Node parent = getParent(removedNode);
            parent.setRight(removedNode.getRight());
        }

        return removedNode;
    }

    private void removeFirst() {
        root = getFirst().getRight();
    }

    private Node getFirst() {
        Node current = root;
        while (current.getLeft() != null) {
            current = current.getLeft();
        }
        return current;
    }

    private Node getLast() {
        Node current = root;
        while (current.getRight() != null) {
            current = current.getRight();
        }
        return current;
    }

    private Node getNodeAt(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }

        Node current = getFirst();
        while (current != null && index-- > 0) {
            current = current.getRight();
        }
        return current;
    }

    private Node getParent(Node node) {
        if (root == null || root == node) {
            return null;
        }

        Node current = root;
        while (current != null) {
            if (current.getRight() == node) {
                return current;
            }
            current = current.getRight();
        }
        return null;
    }
}
