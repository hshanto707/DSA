package com.hshanto707.dataStructures.dynamicArray;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DynamicArrayTest {

  private DynamicArray da;

  @BeforeEach
  void setUp() {
    // Initialize the DynamicArray before each test
    da = new DynamicArray();
  }

  @Test
  void testAdd() {
    da.add(5);
    assertEquals(1, da.size());
    assertEquals(5, da.arr[0]);

    da.add(10);
    assertEquals(2, da.size());
    assertEquals(10, da.arr[1]);

    da.add(6);
    da.add(9);
    assertEquals(4, da.size());
    assertEquals(6, da.arr[2]);
    assertEquals(9, da.arr[3]);
  }

  @Test
  void testIsEmpty() {
    assertTrue(da.isEmpty());

    da.add(5);
    assertFalse(da.isEmpty());

    da.remove(5);
    assertTrue(da.isEmpty());
  }

  @Test
  void testSize() {
    assertEquals(0, da.size());

    da.add(5);
    assertEquals(1, da.size());

    da.add(10);
    assertEquals(2, da.size());

    da.remove(5);
    assertEquals(1, da.size());

    da.remove(10);
    assertEquals(0, da.size());
  }

  @Test
  void testRemove() {
    da.add(5);
    da.add(10);
    da.add(6);

    assertTrue(da.remove(10));
    assertFalse(da.remove(10)); // Removing again should return false

    assertEquals(2, da.size());
    assertEquals(5, da.arr[0]);
    assertEquals(6, da.arr[1]);
  }

  @Test
  void testRemoveAt() {
    da.add(5);
    da.add(10);
    da.add(6);

    da.removeAt(1);
    assertEquals(2, da.size());
    assertEquals(5, da.arr[0]);
    assertEquals(6, da.arr[1]);

    // Removing at an index beyond the current size should be handled gracefully
    assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
      da.removeAt(2);
    });
  }
}
