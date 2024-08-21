package com.hshanto707.dataStructures.stack;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class StackTest {
  private static List<Stack<Integer>> inputs() {
    List<Stack<Integer>> stacks = new ArrayList<>();

    stacks.add(new ListStack<Integer>());
    stacks.add(new ArrayStack<>());
    
    return stacks;
  }

  @ParameterizedTest
  @MethodSource("inputs")
  public void testEmptyStack(Stack<Integer> stack) {
    assertTrue(stack.isEmpty());
  }

  @ParameterizedTest
  @MethodSource("inputs")
  public void testPopOnEmpty(Stack<Integer> stack) {
    assertThrows(Exception.class, () -> stack.pop());
  }

  @ParameterizedTest
  @MethodSource("inputs")
  public void testPeekOnEmpty(Stack<Integer> stack) {
    assertThrows(Exception.class, () -> stack.peek());
  }

  @ParameterizedTest
  @MethodSource("inputs")
  public void testPush(Stack<Integer> stack) {
    stack.push(2);
    assertEquals(1, stack.size());
  }

  @ParameterizedTest
  @MethodSource("inputs")
  public void testPeek(Stack<Integer> stack) {
    stack.push(2);
    assertEquals(stack.peek(), 2);
    assertEquals(stack.size(), 1);
  }

  @ParameterizedTest
  @MethodSource("inputs")
  public void testPop(Stack<Integer> stack) {
    stack.push(2);
    assertEquals(stack.pop(), 2);
    assertEquals(stack.size(), 0);
  }

  @ParameterizedTest
  @MethodSource("inputs")
  public void testExhaustively(Stack<Integer> stack) {
    assertTrue(stack.isEmpty());
    stack.push(1);
    assertFalse(stack.isEmpty());
    stack.push(2);
    assertEquals(stack.size(), 2);
    assertEquals(stack.peek(), 2);
    assertEquals(stack.size(), 2);
    assertEquals(stack.pop(), 2);
    assertEquals(stack.size(), 1);
    assertEquals(stack.peek(), 1);
    assertEquals(stack.size(), 1);
    assertEquals(stack.pop(), 1);
    assertEquals(stack.size(), 0);
    assertTrue(stack.isEmpty());
  }
}
