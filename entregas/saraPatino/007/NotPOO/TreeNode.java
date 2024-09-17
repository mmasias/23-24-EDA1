package NotPOO;

public class TreeNode {
    String key;
    List<TreeNode> children;

    public TreeNode(String item) {
        key = item;
        children = new List<>();
    }
}