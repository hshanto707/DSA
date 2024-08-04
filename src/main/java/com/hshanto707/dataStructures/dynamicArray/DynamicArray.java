package com.hshanto707.dataStructures.dynamicArray;

public class DynamicArray {
  private static final int defaultCap = 5;

  public int[] arr;
  public int len = 0;
  public int capacity = 0;

  // Initialize the array with default capacity
  public DynamicArray() {
    this(defaultCap);
  }

  // Initialize the array with a capacity
  public DynamicArray(int capacity) {
    if (capacity < 0)
      throw new IllegalArgumentException("Illegal Capacity: " + capacity);
    this.capacity = capacity;
    arr = new int[capacity];
  }

  // Make the given array dynamic
  public DynamicArray(int[] array) {
    if (array == null)
      throw new IllegalArgumentException("Array cannot be null");
    arr = java.util.Arrays.copyOf(array, array.length);
    capacity = len = array.length;
  }

  // To get the size of the array
  public int size() {
    return len;
  }

  // To get true/false wheater the array is empty
  public boolean isEmpty() {
    return len == 0;
  }

  // Add a number
  public void add(int num) {
    if (len + 1 >= capacity) {
      if (capacity == 0)
        capacity = 1;
      else
        capacity *= 2; // Double the capacity
      arr = java.util.Arrays.copyOf(arr, capacity);
    }
    arr[len++] = num;
  }

  // Remove at the specific index
  public void removeAt(int index) {
    System.arraycopy(arr, index + 1, arr, index, len - index - 1);
    len--;
    capacity--;
  }

  // Remove an element
  public boolean remove(int num) {
    for (int i = 0; i < len; i++)
      if (arr[i] == num) {
        removeAt(i);
        return true;
      }

    return false;
  }

  // Example usage
  public static void main(String[] args) {
    DynamicArray da = new DynamicArray(10);
    
    da.add(5);
    da.add(10);
    da.add(6);
    da.add(9);

    System.out.println(da);
  }
}
