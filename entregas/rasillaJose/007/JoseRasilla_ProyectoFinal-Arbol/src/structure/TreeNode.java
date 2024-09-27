package structure;

public class TreeNode {

    public boolean keyNode;
    public boolean multiple = false;
    public String nodeName;

    public TreeNode(boolean isKey, String name){
        this.keyNode = isKey;
        this.nodeName = name;
    }

    public TreeNode chilNode;
    public JavaList<TreeNode> children;
    
    public void addChild(TreeNode node){
        chilNode = node;
    }
    public void addChild(JavaList<TreeNode> nodes){
        children = nodes;
    }
    public void addChildToChildren(TreeNode node){
        children.addNode(node);
    }
}
