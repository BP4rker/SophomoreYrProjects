package com.company;

public class ArrayQueue<E> implements Queue<E> {
    public static final int CAPACITY = 1000;
    private E[] data;
    private int front = 0;
    private int t =0;
    public ArrayQueue()
    {
        this(CAPACITY);
    }
    public ArrayQueue(int capacity){
        data = (E[]) new Object[capacity];
    }

    @Override
    public int size() {
        return t;
    }

    @Override
    public boolean isEmpty() {
        return t == 0;
    }

    @Override
    public void enqueue(E e) {
        if (size()== CAPACITY){
            throw new IllegalStateException ("The Queue is Full");
        }
        else{
            int answer = (front+t)%data.length;
            data[answer]=e;
            t++;
        }
    }

    @Override
    public E first() {
        if (isEmpty()){
            return null;
        }
        else{
            return data[front];
        }
    }

    @Override
    public E dequeue() {
        if (isEmpty()){
            return null;
        }
        else{
            E answer = data[front];
            data[front] = null;
            front = (front+1) % data.length;
            t--;

            return answer;
        }
    }
}
