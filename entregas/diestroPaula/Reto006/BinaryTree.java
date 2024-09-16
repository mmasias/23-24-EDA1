public class BinaryTree {
    public static void main(String[] args) {

        BinaryTreeNode root = new BinaryTreeNode(1);
        BinaryTreeNode leftChild = new BinaryTreeNode(2);
        BinaryTreeNode rightChild = new BinaryTreeNode(3);

        root.left = leftChild;
        root.right = rightChild;

        BinaryTreeNode leftOfRoot = root.left;
        BinaryTreeNode rightOfRoot = root.right;
    }
}
