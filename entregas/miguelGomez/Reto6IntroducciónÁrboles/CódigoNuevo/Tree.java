import java.util.ArrayList;
import java.util.List;

public class Tree {
    private TreeNode root;

    public int size() {
        return size(root);
    }

    private int size(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int count = 1;
        for (TreeNode child : node.getChildren()) {
            count += size(child);
        }
        return count;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void insert(String parentValue, String value) {
        TreeNode newNode = new TreeNode(value);
        if (root == null) {
            root = newNode;
        } else {
            TreeNode parentNode = findNode(root, parentValue);
            if (parentNode != null) {
                parentNode.addChild(newNode);
            } else {
                // Manejar el caso donde el nodo padre no existe
                System.out.println("El nodo padre '" + parentValue + "' no existe.");
            }
        }
    }

    private TreeNode findNode(TreeNode node, String value) {
        if (node == null) {
            return null;
        }
        if (node.getValue().equals(value)) {
            return node;
        }
        for (TreeNode child : node.getChildren()) {
            TreeNode foundNode = findNode(child, value);
            if (foundNode != null) {
                return foundNode;
            }
        }
        return null;
    }

    public String[] listAll() {
        List<String> nodeList = new ArrayList<>();
        listAll(root, nodeList);
        return nodeList.toArray(new String[0]);
    }

    private void listAll(TreeNode node, List<String> nodeList) {
        if (node == null) {
            return;
        }
        nodeList.add(node.getValue());
        for (TreeNode child : node.getChildren()) {
            listAll(child, nodeList);
        }
    }
}
