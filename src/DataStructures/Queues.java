/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import java.util.ArrayList;

/**
 *
 * @author Chameera
 */
public class Queues {

    private static ArrayList<Integer> queue = new ArrayList<>();

    public static boolean stackEmpty() {
        return queue.isEmpty();
    }

    public static void enqueue(int x) {
        queue.add(x);
    }

    public static int dequeue() {
        return queue.remove(0);
    }

    public static void main(String[] args) {
        System.out.println(stackEmpty());
        enqueue(10);
        enqueue(345);
        enqueue(5678);

        System.out.println(dequeue());
        System.out.println(dequeue());

        System.out.println(stackEmpty());

    }
}
