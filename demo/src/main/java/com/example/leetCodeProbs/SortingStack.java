package com.example.leetCodeProbs;

import java.util.Stack;
import java.util.stream.Collectors;

public class SortingStack {
    
    public static Stack<Integer> sortStack(Stack stack){
        Stack orderStack = new Stack();
        while(!stack.isEmpty()){
            int temp = (int) stack.pop();
            while(!orderStack.isEmpty() && (int) orderStack.peek() > temp){
                stack.push(orderStack.pop());
            }
            orderStack.push(temp);
        }
        System.out.println(orderStack);
        return orderStack;
        
    }


    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(2);
        stack.push(5);
        stack.push(1);
        stack.push(4);

        System.out.println("Before sorting:");
        System.out.println(stack.stream().collect(Collectors.toList()));


        System.out.println("\nAfter sorting:");

        sortStack(stack);
 
        /*
            EXPECTED OUTPUT:
            ----------------
            Before sorting:
            4
            1
            5
            2
            3
            
            After sorting:
            1
            2
            3
            4
            5

        */
        
    }
    
}

