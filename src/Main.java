import binatytree.BinaryTree;

public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.add(4);
        tree.add(5);
        tree.add(6);
        tree.add(7);
        tree.add(8);
        tree.add(9);
        tree.add(10);
        tree.add(11);
        tree.add(12);
        tree.add(13);
        System.out.println(tree.containsNode(10));

        tree.remove(10);
        System.out.println(tree.containsNode(10));

        System.out.println(tree.containsNode(5));

        tree.remove(5);
        System.out.println(tree.containsNode(5));
    }
}
