package com.hshanto707.dataStructures.linkedList;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SinglyLinkedListTest {
  SinglyLinkedList<Integer> list;

  @BeforeEach
  public void setup() {
    list = new SinglyLinkedList<>();
  }

  @Test
  void testSize() {
    assertEquals(0, list.size(), "Size should be 0 for a new list");
    list.addEnd(1);
    assertEquals(1, list.size(), "Size should be 1 after adding one item");
    list.addEnd(2);
    assertEquals(2, list.size(), "Size should be 2 after adding another item");
    list.removeFirst();
    assertEquals(1, list.size(), "Size should be 1 after removing one item");
  }

  @Test
  void testEmptyList() {
    assertTrue(list.isEmpty(), "List should be empty initially");
    list.addEnd(1);
    assertFalse(list.isEmpty(), "List should not be empty after adding an item");
    list.removeFirst();
    assertTrue(list.isEmpty(), "List should be empty after removing the only item");
  }

  @Test
  void testAddEnd() {
    list.addEnd(1);
    list.addEnd(2);
    list.addEnd(3);
    assertEquals("1 2 3", list.toString(), "List should contain items 1, 2, and 3 in order");
  }

  @Test
  void testAddFront() {
    list.addFront(1);
    list.addFront(2);
    list.addFront(3);
    assertEquals("3 2 1", list.toString(), "List should contain items 3, 2, and 1 in order");
  }

  @Test
  void testClear() {
    list.addEnd(1);
    list.addEnd(2);
    list.clear();
    assertEquals(0, list.size(), "Size should be 0 after clearing the list");
    assertTrue(list.isEmpty(), "List should be empty after clearing");
  }

  @Test
  void testInsertAt() {
    list.addEnd(1);
    list.addEnd(3);
    list.insertAt(2, 1);
    assertEquals("1 2 3", list.toString(), "List should contain items 1, 2, and 3 in order");
    
    assertThrows(IndexOutOfBoundsException.class, () -> list.insertAt(4, -1), "Index -1 should throw exception");
    assertThrows(IndexOutOfBoundsException.class, () -> list.insertAt(4, 4), "Index 4 should throw exception for out of bounds");
  }

  @Test
  void testRemoveAt() {
    list.addEnd(1);
    list.addEnd(2);
    list.addEnd(3);
    list.removeAt(1);
    assertEquals("1 3", list.toString(), "List should contain items 1 and 3 after removing item at index 1");

    list.removeAt(0);
    assertEquals("3", list.toString(), "List should contain item 3 after removing item at index 0");

    list.removeAt(0);
    assertTrue(list.isEmpty(), "List should be empty after removing the last item");
    
    assertThrows(IndexOutOfBoundsException.class, () -> list.removeAt(-1), "Index -1 should throw exception");
    assertThrows(IndexOutOfBoundsException.class, () -> list.removeAt(0), "Index 0 should throw exception for out of bounds");
  }

  @Test
  void testRemoveFirst() {
    list.addEnd(1);
    list.addEnd(2);
    list.addEnd(3);
    list.removeFirst();
    assertEquals("2 3", list.toString(), "List should contain items 2 and 3 after removing the first item");
  }

  @Test
  void testRemoveLast() {
    list.addEnd(1);
    list.addEnd(2);
    list.addEnd(3);
    list.removeLast();
    assertEquals("1 2", list.toString(), "List should contain items 1 and 2 after removing the last item");
  }

  @Test
  void testSearch() {
    list.addEnd(1);
    list.addEnd(2);
    list.addEnd(3);
    assertDoesNotThrow(() -> list.search(2), "Search should not throw exception for existing item");
    assertThrows(IllegalArgumentException.class, () -> list.search(null), "Searching for null should throw IllegalArgumentException");
    
    assertEquals(1, list.search(2), "Item 2 should be found at index 1");
    assertEquals(-1, list.search(4), "Item 4 does not exist in the list");
  }

  @Test
  void testPrint() {
    list.addEnd(1);
    list.addEnd(2);
    list.addEnd(3);
    assertEquals("1 2 3", list.toString(), "List should print items 1, 2, and 3");
  }
}
