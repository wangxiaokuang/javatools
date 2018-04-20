package tum0r.test;

import tum0r.datastructure.Stack;

public class StackTest {
	public static void test() {
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();
		stack.push(123);
		stack2.push(123);
		System.out.println(stack.equals(stack2));
	}
}
