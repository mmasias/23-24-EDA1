package entregas.sergioMayen.Reto6;

public class BinaryTree<T extends Comparable<T>> implements IDataStructure<T> {
    private TreeNode<T> root;

    public TreeNode<T> getRoot() {
        return root;
    }

    public void insert(T data) {
        if (root == null) {
            root = new TreeNode<>(data);
        } else {
            insertNode(data, root);
        }
    }

    private void insertNode(T data, TreeNode<T> node) {
        if (node != null) {
            int comparison = data.compareTo(node.getData());
            if (comparison < 0) {
                if (node.getLeft() == null) {
                    node.setLeft(new TreeNode<>(data));
                } else {
                    insertNode(data, node.getLeft());
                }
            } else if (comparison > 0) {
                if (node.getRight() == null) {
                    node.setRight(new TreeNode<>(data));
                } else {
                    insertNode(data, node.getRight());
                }
            }
        }
    }

    @Override
    public int size() {
        return countNodes(root);
    }

    @Override
    public TreeNode<T> getFirst() {
        throw new UnsupportedOperationException("Unimplemented method 'getFirst'");
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    public TreeNode<T> search(T data) {
        return searchNode(root, data);
    }

    private TreeNode<T> searchNode(TreeNode<T> node, T data) {
        if (node == null) {
            return null;
        }
        if (node.getData().equals(data)) {
            return node;
        }
        TreeNode<T> foundNode = searchNode(node.getLeft(), data);
        return (foundNode != null) ? foundNode : searchNode(node.getRight(), data);
    }

    public void remove(T data) {
        TreeNode<T> node = search(data);
        if (node != null) {
            TreeNode<T> parent = findParent(node);
            if (node.getLeft() != null && node.getRight() != null) {
                removeNodeWithTwoChildren(node, parent);
            } else {
                removeNodeWithEmptyOrSingleChild(node, parent);
            }
        }
    }

    private TreeNode<T> findParent(TreeNode<T> search) {
        return findParentNode(root, search);
    }

    private TreeNode<T> findParentNode(TreeNode<T> node, TreeNode<T> search) {
        if (node != null) {
            if (node.getLeft() == search || node.getRight() == search) {
                return node;
            }
            TreeNode<T> foundInLeft = findParentNode(node.getLeft(), search);
            if (foundInLeft != null) {
                return foundInLeft;
            }
            return findParentNode(node.getRight(), search);
        }
        return null;
    }

    private void removeNodeWithTwoChildren(TreeNode<T> node, TreeNode<T> parent) {
        TreeNode<T> leftmostValue = findLeftmostChild(node.getRight());
        removeNodeWithEmptyOrSingleChild(leftmostValue, findParent(leftmostValue));
        node.setData(leftmostValue.getData());
    }

    private TreeNode<T> findLeftmostChild(TreeNode<T> node) {
        return (node.getLeft() != null) ? findLeftmostChild(node.getLeft()) : node;
    }

    private void removeNodeWithEmptyOrSingleChild(TreeNode<T> node, TreeNode<T> parent) {
        TreeNode<T> child = (node.getLeft() != null) ? node.getLeft() : node.getRight();
        if (parent != null) {
            if (node == parent.getLeft()) {
                parent.setLeft(child);
            } else {
                parent.setRight(child);
            }
        } else {
            root = child;
        }
    }

    private int countNodes(TreeNode<T> node) {
        return (node != null) ? 1 + countNodes(node.getLeft()) + countNodes(node.getRight()) : 0;
    }

    public void preOrderTraversal() {
        preOrder(root);
    }

    private void preOrder(TreeNode<T> node) {
        if (node != null) {
            System.out.println(node.getData().toString());
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }

    public void inOrderTraversal() {
        inOrder(root);
    }

    private void inOrder(TreeNode<T> node) {
        if (node != null) {
            inOrder(node.getLeft());
            System.out.println(node.getData().toString());
            inOrder(node.getRight());
        }
    }

    public void postOrderTraversal() {
        postOrder(root);
    }

    private void postOrder(TreeNode<T> node) {
        if (node != null) {
            postOrder(node.getLeft());
            postOrder(node.getRight());
            System.out.println(node.getData().toString());
        }
    }

    @Override
    public Object[] listData() {
        throw new UnsupportedOperationException("Unimplemented method 'listData'");
    }
}

