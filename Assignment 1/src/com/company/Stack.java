package com.company;
public interface Stack<Type> {
    int size();
    boolean isEmpty();
    void push(Type E);
    Type top();
    Type pop();
}