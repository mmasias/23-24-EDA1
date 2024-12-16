package entregas.garcíaDiego.Ex006;

public class TreeNode {
    private int value;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void add(int value) {
        if (value < this.value) {
            if (this.left == null) {
                this.left = new TreeNode(value);
            } else {
                this.left.add(value);
            }
        } else {
            if (this.right == null) {
                this.right = new TreeNode(value);
            } else {
                this.right.add(value);
            }
        }
    }

}
