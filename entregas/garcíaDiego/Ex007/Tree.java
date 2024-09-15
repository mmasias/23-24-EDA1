public class Tree<T extends TreeData> {
    private TreeNode<T> root;

    public TreeNode<T> getRoot() {
        return root;
    }

    public void setRoot(TreeNode<T> root) {
        this.root = root;
    }

    public Tree(TreeNode<T> root) {
        this.root = root;
    }

    public void preOrder(TreeNode<T> node){
        if(node!=null){
            System.out.println(node.getValue().getInformation());
            for(int i=0;i<node.getNodeChildren().size();i++){
                preOrder(node.getNodeChildren().getObject(i));
            }
        }
    }

    public void postOrder(TreeNode<T> node){
        if(node!=null){
            for(int i=0;i<node.getNodeChildren().size();i++){
                postOrder(node.getNodeChildren().getObject(i));
            }
            System.out.println(node.getValue().getInformation());
        }
    }
    
}
