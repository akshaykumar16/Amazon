package com.pratice.stack;

import java.util.regex.Pattern;

public class MinimumStack {


    private Stack<Integer> stack=new Stack<>();
    private Stack<Integer> minStack=new Stack<>();


    public void push(int data)
    {
        if(minStack.getSize()==0)
        {
            minStack.push(data);
        }
        else
        {
            if(minStack.peek()>data)
            {
                minStack.push(data);
            }
            else
            {
                minStack.push(minStack.peek());
            }
        }

        stack.push(data);
    }



    public int pop()
    {
        minStack.pop();
        return stack.pop();
    }

    public int getMinimum()
    {
        return minStack.peek();
    }
}
