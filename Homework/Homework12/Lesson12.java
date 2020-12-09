package Homework.Homework12;

public class Lesson12 {
    public static void main(String[] args) {
        BinarySearchTree bt = new BinarySearchTree();
        bt.add(6);
        bt.add(4);
        bt.add(8);
        bt.add(3);
        bt.add(5);
        bt.add(7);
        bt.add(9);
        bt.traversePreOrder();
        System.out.println("\n");
        bt.traverseInOrder();
        System.out.println("\n");
        bt.traversePostOrder();
        System.out.println("\n");
        bt.traverseLevelOrder();
    }
}
