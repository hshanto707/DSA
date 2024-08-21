package com.hshanto707.dataStructures.stack;

public interface Stack<T> {
  // Returns the size of the stack
  public int size();

  // Return if the stack is empty
  public boolean isEmpty();

  // Push an element on the stack
  public void push(T elem);

  // Pop an element of the stack
  public T pop();

  // Returns the top value of the stack
  public T peek();
}
