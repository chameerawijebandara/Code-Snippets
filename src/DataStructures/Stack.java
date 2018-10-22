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
public class Stack {

    private static ArrayList<Integer> stack = new ArrayList<>();

    public static boolean stackEmpty() {
        return stack.isEmpty();
    }
    
    public static void push(int x)
    {
        stack.add(x);
    }
    
    public static int pop()
    {
        return stack.remove(stack.size()-1);
    }
    public static void main(String[] args) {
        System.out.println(stackEmpty());
        push(10);
        push(345);
        push(5678);
        
        System.out.println(pop());
        System.out.println(pop());
        
        System.out.println(stackEmpty());
        
    }
}
