package com.hshanto707.dataStructures.stack;

import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayStack<T> implements Stack<T> {
  private int size;
  private int capacity;
  private Object[] data;

  public ArrayStack() {
    capacity = 16;
    data = new Object[capacity];
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public void push(T elem) {
    if (elem == null) {
      throw new IllegalArgumentException("Data cannot be null");
    } else {
      if (size == capacity) {
        increaseCapacity();
      }
      data[size++] = elem;
    }
  }

  private void increaseCapacity() {
    size *= 2;
    data = Arrays.copyOf(data, capacity);
  }

  @Override
  @SuppressWarnings("unchecked")
  public T pop() {
    if (isEmpty()) {
      throw new EmptyStackException();
    }

    T elem = (T) data[--size];
    data[size] = null;
    return elem;
  }

  @Override
  @SuppressWarnings("unchecked")
  public T peek() {
    if (isEmpty()) {
      throw new EmptyStackException();
    }

    return (T) data[size - 1];
  }

  public void print() {
    for (int i = 0; i < size; i++) {
      System.out.print(data[i] + " ");
    }
  }
}
