package Arboles.model;

class NaryTreeNode {
    String data;
    NaryTreeNode[] children;

    public NaryTreeNode(String data, int numChildren) {
        this.data = data;
        this.children = new NaryTreeNode[numChildren];
    }

    public void addChild(int index, NaryTreeNode child) {
        if (index >= 0 && index < children.length) {
            children[index] = child;
        } else {
            System.out.println("Invalid index for adding child.");
        }
    }

    public void printTree() {
        printTree(this, 0);
    }

    private void printTree(NaryTreeNode node, int depth) {
        if (node == null) {
            return;
        }

        for (int i = 0; i < depth; i++) {
            System.out.print("  ");
        }

        System.out.println(node.data);

        for (NaryTreeNode child : node.children) {
            printTree(child, depth + 1);
        }
    }
}

public class NaryTree {
    public static void main(String[] args) {
        // Creating an example N-ary tree
        NaryTreeNode root = new NaryTreeNode("1", 3);
        root.addChild(0, new NaryTreeNode("2", 2));
        root.addChild(1, new NaryTreeNode("3", 1));
        root.addChild(2, new NaryTreeNode("4", 0));

        root.children[0].addChild(0, new NaryTreeNode("5", 0));
        root.children[0].addChild(1, new NaryTreeNode("6", 1));

        root.children[0].children[1].addChild(0, new NaryTreeNode("7", 0));

        // Print the tree
        root.printTree();
    }
}
