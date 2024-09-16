public class Tree<T> {
    private Node<T> root;

    public Tree() {
        this.root = null;
    }

    public Node<T> getRoot() {
        return root;
    }

    public void insert(Node<T> newNode) {
        if (root == null) {
            root = newNode;
        } else {
            insertRecursive(root, newNode);
        }
    }

    private void insertRecursive(Node<T> current, Node<T> newNode) {
        if (newNode.getIndex() < current.getIndex()) {
            if (current.getLeft() == null) {
                current.setLeft(newNode);
            } else {
                insertRecursive(current.getLeft(), newNode);
            }
        } else if (newNode.getIndex() > current.getIndex()) {
            if (current.getRight() == null) {
                current.setRight(newNode);
            } else {
                insertRecursive(current.getRight(), newNode);
            }
        }
        
    }

    public Node<T> find(int index) {
        return findRecursive(root, index);
    }

    private Node<T> findRecursive(Node<T> current, int index) {
        if (current == null) {
            return null;
        }
        if (index == current.getIndex()) {
            return current;
        }
        return index < current.getIndex() ? findRecursive(current.getLeft(), index) : findRecursive(current.getRight(), index);
    }

    public void printInOrder() {
        printInOrderRecursive(root);
    }

    private void printInOrderRecursive(Node<T> node) {
        if (node != null) {
            printInOrderRecursive(node.getLeft());
            System.out.println(node.getData());
            printInOrderRecursive(node.getRight());
        }
    }

    public void printInOrder(StringBuilder sb) {
        printInOrderRecursive(root, sb);
    }

    private void printInOrderRecursive(Node<T> node, StringBuilder sb) {
        if (node != null) {
            printInOrderRecursive(node.getLeft(), sb);
            sb.append(node.getData().toString()).append("\n");
            printInOrderRecursive(node.getRight(), sb);
        }
    }
}