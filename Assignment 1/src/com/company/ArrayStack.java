package com.company;

public class ArrayStack<E> implements Stack<E> {
    public static final int CAPACITY = 100;
    private E[] data;
    private int t = 0;
    public ArrayStack()
    {
        this(CAPACITY);
    }
    public ArrayStack(int capacity){
        data =(E[]) new Object[capacity];
    }
    @Override
    public int size() {
        return t;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void push(E e) {
        if (size()== data.length){
            throw new IllegalStateException ("The Stack is Full");
        }
        else{
            data[t] = e;
            t++;

        }
    }

    @Override
    public E top() {
        if (isEmpty()){
            return null;
        }
        else{
            return data[t-1];
        }
    }

    @Override
    public E pop() {
        if (isEmpty()){
            return null;
        }
        else{
            E answer = data[t];
            data[t] = null;
            t--;
            return answer;
        }
    }
}
