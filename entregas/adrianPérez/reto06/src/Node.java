import java.util.ArrayList;
import java.util.List;

public class Node {
    private String name;
    private List<Node> children;

    public Node(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }

    public void addChild(Node node) {
        this.children.add(node);
    }

    public List<Node> getChildren() {
        return this.children;
    }

    public String getName() {
        return this.name;
    }
}