package dataStructures;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Create by Amit on 9/4/20
 */
public class Stacks {

    public static void main(String[] args) throws InterruptedException {

/*
        Stack stack = new Stack();

        for (int i = 1; i < 10 ; i++) {
            stack.push(i);
        }

        System.out.println(stack);

        while(!stack.empty()){
            System.out.print(stack.pop());
            System.out.print(",");
            Thread.sleep(1000);
        }
*/

        // Reverse contents of String, Stacks are great to reverse any data structure

        String name = "Kshirsagar";

        Stack stack = new Stack();

        for (int i = 0; i < name.length() ; i++) {

            stack.push(name.charAt(i));
        }

        System.out.println(stack);
        String tmp = "";

        while(!stack.empty()){
            tmp = tmp.concat(stack.pop().toString());
        }

        System.out.println("Reversed string = " + tmp);
    }
}
