package algorithms.solution;

public class IsBinarySearchTree {

    /**
     * Опишите алгоритм, который вернёт True если дерево является двоичным деревом поиска
     * и False если не является.
     *
     * @param args
     */
    public static void main(String[] args) {
        Node root = new Node(12);
        root.left = new Node(7);
        root.right = new Node(16);

        root.left.left = new Node(4);
        root.left.right = new Node(11);

        root.right.left = new Node(14);
        root.right.right = new Node(18);

        root.right.right.left = new Node(17);

        System.out.println("IsBinary = " + isBst(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static boolean isBst(Node root, int min, int max) {
        if (root == null) return true;

        return (min < root.value && root.value < max) &&
                isBst(root.left, min, root.value) &&
                isBst(root.right, root.value, max);
    }
}
