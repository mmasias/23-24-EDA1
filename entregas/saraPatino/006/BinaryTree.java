public class BinaryTree<T extends Comparable> implements  IDataStructure<T>{
    private     TreeNode<T> root;

    public BinaryTree() {
        this.root=null;
    }
    public void insert(T data){
        if (root==null){
            root= new TreeNode<>(data);
        }else {insert(data,root);}

    }
    public void insert(T data, TreeNode<T> node){
        if (node !=null){
            final int comparison= data.compareTo(node.getData());
            if (comparison<0){
                if (node.getLeftNode() ==null){
                    node.setLeftNode(new TreeNode<>(data));
                }else {
                    insert(data, node.getLeftNode());
                }
            } else if (comparison>0) {
                if (node.getRightNode()==null){
                    node.setRightNode(new TreeNode<>(data));
                }else {
                    insert(data, node.getRightNode());
                }

            }
        }
    }
    private TreeNode<T> searchNode(TreeNode<T> node, T data){
        if (node==null){
            return null;
        }else {
            if (node.getData()==data)
                return node;
            final TreeNode<T> inLeft= searchNode(node.getLeftNode(),data);
            if (inLeft!=null )
                return node;
            return searchNode(node.getRightNode(),data);

        }

    }
    public TreeNode<T> search(T data){
        return searchNode(root,data);
    }
    public void remove(T data){

    }
    public void preorden() {
        preordenRec(root);
    }

    private void preordenRec(TreeNode<T> raiz) {
        if (raiz != null) {
            System.out.println(raiz.getData().toString() + " ");
            preordenRec(raiz.getLeftNode());
            preordenRec(raiz.getRightNode());
        }
    }
    public void inorden() {
        inordenRec(root);
    }

    private void inordenRec(TreeNode<T> raiz) {
        if (raiz != null) {
            inordenRec(raiz.getLeftNode());
            System.out.println(raiz.getData().toString() + " ");
            inordenRec(raiz.getRightNode());
        }
    }
    public void postorden() {
        postordenRec(root);
    }

    private void postordenRec(TreeNode<T>  raiz) {
        if (raiz != null) {
            postordenRec(raiz.getLeftNode());
            postordenRec(raiz.getRightNode());
            System.out.println(raiz.getData().toString() + " ");
        }
    }
    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Object[] listData() {
        return new Object[0];
    }
}