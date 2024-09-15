package entregas.garcíaDiego.Ex006;

public class Ex006 {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.add(5);
        tree.add(3);
        tree.add(7);
        tree.add(2);
        tree.add(4);
        tree.add(6);
        tree.add(8);
        tree.preorderTrigger();
        tree.inorderTrigger();
        tree.postorderTrigger();

        System.out.println("-".repeat(10) + "Preorder" + "-".repeat(10));
        tree.preorderTrigger();
        System.out.println("-".repeat(10) + "Inorder" + "-".repeat(10));
        tree.inorderTrigger();
        System.out.println("-".repeat(10) + "Postorder" + "-".repeat(10));
        tree.postorderTrigger();
        
    }
}
