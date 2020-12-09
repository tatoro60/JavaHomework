package Homework.Homework12;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    private Node root;

    public void add(Integer value) {
        root = addRecursion(root, value);
    }

    private Node addRecursion(Node current, Integer val) {
        if (current == null) {
            return new Node(val);
        }
        if (current.data < val) {
            current.right = addRecursion(current.right, val);
        } else {
            current.left = addRecursion(current.left, val);
        }
        return current;
    }

    public boolean contains(Integer value) {
        return find(root, value) != null;
    }

    private Node find(Node current, Integer val) {
        if (current == null) {
            return null;
        }
        if (current.data == val) {
            return current;
        }
        if (current.data < val) {
            return find(current.right, val);
        }
        return find(current.left, val);

    }

    public void max() {
        if (root == null) {
            System.out.println("Tree is empty");
        } else {
            Node current = root;
            while (current.right != null) {
                current = current.right;
            }
            System.out.println("Maximum is " + current.data);
        }
    }

    public void min() {
        if (root == null) {
            System.out.println("Tree is empty");
        } else {
            Node current = root;
            while (current.left != null) {
                current = current.left;
            }
            System.out.println("Minimum is " + current.data);
        }
    }

    public void remove(Integer val){
        root = removeRecursion(root,val);
    }

    private Node removeRecursion(Node current, Integer val) {
        if(current == null){
            return null;
        }
        if(current.data == val){
            if(current.right == null && current.left == null){
                return null;
            }
            if(current.right == null){
                return current.left;
            }
            if(current.left == null){
                return current.right;
            }
            Node minimum = current.right;
            while(minimum.left!=null){
                minimum = minimum.left;
            }
            current.data = minimum.data;
            current.right = removeRecursion(current.right,minimum.data);
            return current;

        }
        if(val < current.data){
            current.left = removeRecursion(current.left,val);
            return current;
        }
        current.right = removeRecursion(current.right,val);
        return current;

    }

    public void traversePreOrder(){
        traversePreOrder(root);
    }

    private void traversePreOrder(Node node) {
        if(node!=null){
            System.out.print(node.data+" ");
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    public void traverseInOrder(){
        traverseInOrder(root);
    }

    private void traverseInOrder(Node node) {
        if(node!=null){
            traverseInOrder(node.left);
            System.out.print(node.data+" ");
            traverseInOrder(node.right);
        }
    }

    public void traversePostOrder(){
        traversePostOrder(root);
    }

    private void traversePostOrder(Node node) {
        if(node!=null){
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            System.out.print(node.data+" ");
        }
    }

    public void traverseLevelOrder(){
        if(root == null){
            return;
        }
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {

            Node node = nodes.remove();

            System.out.print(node.data+" ");

            if (node.left != null) {
                nodes.add(node.left);
            }

            if (node.right != null) {
                nodes.add(node.right);
            }
        }


    }
}
