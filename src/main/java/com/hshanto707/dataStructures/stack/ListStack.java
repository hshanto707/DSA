package com.hshanto707.dataStructures.stack;

import java.util.Iterator;
import java.util.LinkedList;

public class ListStack<T> implements Iterable<T>, Stack<T> {
  private LinkedList<T> list = new LinkedList<T>();

  // Create an empty stack
  public ListStack() {};

  // Create a stack with an initial element
  public ListStack(T firstElem) {
    push(firstElem);
  }

  // Return the number of elements in the stack
  public int size() {
    return list.size();
  }

  // Check if the stack is empty
  public boolean isEmpty() {
    return list.isEmpty();
  }

  // Push an element onto the stack
  public void push(T elem) {
    list.addLast(elem);
  }

  // Pop an element off the stack
  public T pop() {
    if (isEmpty()) {
      throw new IllegalStateException("Stack is empty");
    }
    return list.removeLast();
  }

  // Return the top element of the stack
  public T peek() {
    if (isEmpty()) {
      throw new IllegalStateException("Stack is empty");
    }
    return list.peekLast();
  }

  // Searches for elements in the stack
  public int search(T elem) {
    return list.lastIndexOf(elem);
  }

  // Allow users to iterate through the stack using an iterator
  @Override
  public Iterator<T> iterator() {
    return list.iterator();
  }
}
