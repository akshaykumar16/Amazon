package com.pratice.stack;

public class Stack<T> {

    private static final int MAX_SIZE=40;


    private T top;


    private int size=0;

    private T[] elements;


    public Stack()
    {
        this.elements=(T[])new Object[MAX_SIZE];
    }


    public void push(T data)
    {
        if(size==MAX_SIZE)
        {
            System.out.println("The stack is Full");
            return;
        }
        else
        {

            this.elements[size]=data;
            this.top=data;
            size++;
        }

    }


    public T pop()
    {
        if(size==0)
        {
            System.out.println("The stack is empty");
            return null;
        }
        else
        {
            T temp=this.elements[size-1];
            size--;
            top=elements[size];
            return temp;

        }
    }


    public T peek()
    {
        if(size==0)
        {
            System.out.println("The stack is empty");
            return null;
        }

        return top;
    }

    public int getSize()
    {
        return size;
    }


    public boolean isEmpty()
    {
        return size==0;
    }

    public boolean isFull()
    {
        return getSize()==MAX_SIZE;
    }



 }
