package ProyectoFinal;

import java.util.ArrayList;
import java.util.List;

public class Tree<T> {
    private TreeNode<T> root;

    public Tree() {
        this.root = null;
    }

    public void add(T data) {
        TreeNode<T> newNode = new TreeNode<>(data);
        if (root == null) {
            root = newNode;
        } else {
            addRecursive(root, newNode);
        }
    }

    private void addRecursive(TreeNode<T> current, TreeNode<T> newNode) {
        if (current.getChildren().isEmpty()) {
            current.getChildren().add(newNode);
        } else {
            // Añadir el nodo al final de los hijos del nodo actual
            current.getChildren().get(current.getChildren().size() - 1).getChildren().add(newNode);
        }
    }

    public T find(T data) {
        TreeNode<T> resultNode = findRecursive(root, data);
        if (resultNode != null) {
            return resultNode.getData();
        }
        return null;
    }

    private TreeNode<T> findRecursive(TreeNode<T> current, T data) {
        if (current == null) {
            return null;
        }

        if (current.getData().equals(data)) {
            return current;
        }

        for (TreeNode<T> child : current.getChildren()) {
            TreeNode<T> result = findRecursive(child, data);
            if (result != null) {
                return result;
            }
        }
        return null;
    }

    public List<T> getAllData() {
        List<T> dataList = new ArrayList<>();
        if (root != null) {
            addDataToList(root, dataList);
        }
        return dataList;
    }

    private void addDataToList(TreeNode<T> node, List<T> dataList) {
        if (node == null) {
            return;
        }
        dataList.add(node.getData());
        for (TreeNode<T> child : node.getChildren()) {
            addDataToList(child, dataList);
        }
    }
}
