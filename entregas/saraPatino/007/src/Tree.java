package src;

public class Tree {
    TreeNode root;

    Tree() {
        root = null;
    }

    public static void printTree(TreeNode node, int depth) {
        if (node == null) {
            return;
        }

        for (int i = 0; i < depth; i++) {
            System.out.print("    "); // Espacios para la indentación
        }

        System.out.println(node.key);

        List<TreeNode> children = node.children;
        Object[] array = children.listData();
        for (Object child : array) {
            printTree((TreeNode) child, depth + 1);
        }
    }

    TreeNode recursiveInsert(TreeNode node, String key) {
        if (node == null) {
            return new TreeNode(key);
        }

        TreeNode newNode = new TreeNode(key);
        node.children.insert(newNode, -1);

        return node;
    }
}