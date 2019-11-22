package com.pratice.stack;



public class MainStack {

    public static void main(String[] args) {

     MinimumStack minimumStack=new MinimumStack();
     minimumStack.push(2);
        minimumStack.push(3);
        minimumStack.push(4); minimumStack.push(5); minimumStack.push(6);

        minimumStack.pop();
        System.out.println(minimumStack.getMinimum());
        minimumStack.pop();
        System.out.println(minimumStack.getMinimum());
        minimumStack.pop();
        System.out.println(minimumStack.getMinimum());
        minimumStack.pop();
        System.out.println(minimumStack.getMinimum());
        minimumStack.pop();
        System.out.println(minimumStack.getMinimum());

    }



}
