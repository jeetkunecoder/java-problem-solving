package com.playground.base.stack;

public class Stack<T> {

    private T[] arr;
    private int top;
    private int maxSize;

    public Stack(int maxSize) {
        this.maxSize = maxSize;
        this.top = -1;
        arr = (T[])new Object[maxSize];
    }

    public int getCapacity() {
        return maxSize;
    }

    void push(T data) {
        if (isFull()) {
            System.err.println("The stack is at full capacity");
            return;
        }

        arr[++top] = data;
    }

    T pop() {
        if (isEmpty()) return null;
        return arr[top--];
    }

    boolean isEmpty() {
        return top == -1;
    }

    boolean isFull() {
        return maxSize - 1 == top;
    }

    T top() {
        if (isEmpty()) {
            return null;
        }
        return arr[top];
    }
}
