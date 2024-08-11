package com.hshanto707.dataStructures.linkedList;

import java.util.NoSuchElementException;

public class SinglyLinkedList<T> {
  private int size = 0;
  private Node head = null;
  private Node tail = null;

  // Defining the Node class
  private class Node {
    T data;
    Node next;

    Node(T data, Node next) {
      this.data = data;
      this.next = next;
    }
  }

  // To get the size of list
  public int size() {
    return size;
  }

  // To check if list is empty
  public boolean isEmpty() {
    return size() == 0;
  }

  // Add an item in the front of the list
  public void addFront(T data) {
    if (data == null) {
      throw new IllegalArgumentException("Data cannot be null");
    }

    Node newNode = new Node(data, head);

    head = newNode;
    if (tail == null) {
      tail = newNode;
    }
    size++;
  }

  // Add an item in the back of the list
  public void addEnd(T data) {
    if (data == null) {
      throw new IllegalArgumentException("Data cannot be null");
    }

    Node newNode = new Node(data, null);

    if (head == null) {
      head = newNode;
    } else {
      tail.next = newNode;
    }
    tail = newNode;
    size++;
  }

  // Add an item at the given index
  public void insertAt(T data, int index) {
    if (data == null) {
      throw new IllegalArgumentException("Data cannot be null");
    }

    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException("Index out of bounds");
    }

    if (index == 0) {
      addFront(data);
      return;
    }

    Node newNode = new Node(data, null);

    Node current = head;

    if (index == size) {
      tail = newNode;
      size++;
      return;
    }

    for (int i = 1; i < index; i++) {
      current = current.next;
    }
    newNode.next = current.next;
    current.next = newNode;

    size++;
  }

  // Remove the first item of the list
  public void removeFirst() {
    if (head == null) {
      throw new NoSuchElementException("List is empty");
    }

    head = head.next;
    size--;
  }

  // Remove the last item of the list
  public void removeLast() {
    if (head == null) {
      throw new NoSuchElementException("List is empty");
    }

    if (head == tail) {
      head = null;
      tail = null;
      size = 0;
      return;
    }

    Node current = head;

    while (current.next != tail) {
      current = current.next;
    }
    current.next = null;
    tail = current;
    size--;
  }

  // Remove an item of the given index
  public void removeAt(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("Index out of bounds");
    }

    if (index == 0) {
      removeFirst();
      return;
    } else if (index == size - 1) {
      removeLast();
      return;
    }

    Node current = head;
    for (int i = 0; i < index - 1; i++) {
      current = current.next;
    }
    current.next = current.next.next;
    size--;
  }

  // Delete the list
  public void clear() {
    head = null;
    size = 0;
  }

  // Search an item in the list
  public int search(T data) {
    if (data == null) {
      throw new IllegalArgumentException("Data cannot be null");
    }

    if (head == null) {
      throw new NoSuchElementException("List is empty");
    }

    Node current = head;

    for (int i = 0; i < size; i++) {
      if (current.data == data) {
        return i;
      }
      current = current.next;
    }

    return -1;
  }

  // Convert the list to a string
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    Node current = head;
    while (current != null) {
      sb.append(current.data).append(" ");
      current = current.next;
    }
    return sb.toString().trim();
  }

  // Print the list
  public void print() {
    System.out.println(this.toString());
  }

  public static void main(String[] args) {
    SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();

    list.addEnd(2);
    list.addEnd(4);
    list.addEnd(5);
    list.addFront(1);
    list.insertAt(3, 2);

    System.out.print("List: ");
    list.print();
  }
}
