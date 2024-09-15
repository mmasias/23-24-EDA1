package code;

public class App {
    public static void main(String[] args) throws Exception {
        Node root = new Node("CEO");
        Node child1 = new Node("Head Sales");
        Node child2 = new Node("Sales Executive 1");
        Node child3 = new Node("Sales Executive 2");

        root.addChild(child1);
        child1.addChild(child2);
        child1.addChild(child3);

        System.out.println("CEO's Children: ");
        for (Node node : root.getChildren()) {
            System.out.println(node.getName());
        }

        System.out.println("Head Sales's Children: ");
        for (Node node : child1.getChildren()) {
            System.out.println(node.getName());
        }
    }
}
