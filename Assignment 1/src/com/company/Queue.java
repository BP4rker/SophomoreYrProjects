package com.company;
public interface Queue<Type> {
    int size();
    boolean isEmpty();
    void enqueue(Type e);
    Type first();
    Type dequeue();
}
