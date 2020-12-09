package Homework.Homework12;

import java.util.ArrayDeque;

public class Lesson12 {
    public static void main(String[] args) {/*
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
        */
        ArrayDeque<String> fruits = new ArrayDeque<>();
        fruits.add("apple");
        fruits.addLast("orange");
        fruits.offer("peach");
        fruits.offerLast("watermelon");
        System.out.println(fruits);
        System.out.println(fruits.pollFirst());//poll,pop
        System.out.println(fruits);
        System.out.println(fruits.peek());
        System.out.println("----------");
        ArrayDeque<String> vegetables = new ArrayDeque<>();
        vegetables.addFirst("tomato");
        vegetables.offerFirst("cucumber");
        vegetables.push("potato");
        System.out.println(vegetables);
        System.out.println(vegetables.pollLast());
        System.out.println(vegetables);
        System.out.println(vegetables.peekLast());
    }
}
