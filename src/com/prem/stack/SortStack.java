package com.prem.stack;

import java.util.Stack;

public class SortStack {

    private static Stack<Integer> stack;
    public SortStack(){
        stack= new Stack<>();
        stack.add(4);
        stack.add(3);
        stack.add(2);
        stack.add(1);
    }


    public Stack<Integer> sortStack(Stack<Integer> mainStack){
        Stack<Integer> tempStack= new Stack<>();

        while(!mainStack.isEmpty()){
            int mainPopped=mainStack.pop();
            if (tempStack.isEmpty()) {
                tempStack.push(mainPopped);
            }
            else if(mainPopped<tempStack.peek()){
                tempStack.push(mainPopped);
            }
            else {
                while(!tempStack.isEmpty() && mainPopped>tempStack.peek()) {
                    mainStack.push(tempStack.pop());
                }
                tempStack.push(mainPopped);
            }
        }
        while (!tempStack.isEmpty()) {
            mainStack.push(tempStack.pop());
        }
        return mainStack;
    }

    public static void main(String[] args) {
        Stack<Integer> result=new SortStack().sortStack(stack);
        System.out.println(result.toString());
    }


}
