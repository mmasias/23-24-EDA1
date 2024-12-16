package entregas.garcíaDiego.Ex006;

public class Tree {
    TreeNode root;

    public Tree() {
        this.root = null;
    }

    public void add(int value) {
        if (this.root == null) {
            this.root = new TreeNode(value);
        } else {
            this.root.add(value);
        }
    }

    public void preorderTrigger() {
        this.preorder(this.root);
    }

    public void preorder(TreeNode node) {
        if (node == null) {
            return;
        } else {
            System.out.println(node.getValue());
            preorder(node.getLeft());
            preorder(node.getRight());
        }

    }

    public void inorderTrigger() {
        this.inorder(this.root);
    }

    public void inorder(TreeNode node) {
        if (node == null) {
            return;
        } else {
            inorder(node.getLeft());
            System.out.println(node.getValue());
            inorder(node.getRight());
        }
    }

    public void postorderTrigger() {
        this.postorder(this.root);
    }

    public void postorder(TreeNode node) {
        if (node == null) {
            return;
        } else {
            postorder(node.getLeft());
            postorder(node.getRight());
            System.out.println(node.getValue());
        }
    }
}
