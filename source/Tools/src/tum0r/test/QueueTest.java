package tum0r.test;

import tum0r.datastructure.Queue;

public class QueueTest {
	public static void test() {
		Queue<Integer> queue = new Queue<>();
		queue.push(123);
		queue.push(456);
		queue.push(789);
		System.out.println(queue.size());
		System.out.println(queue.getFront());
		System.out.println(queue.getBack());
		System.out.println(queue.pop());
		Queue<Integer> copy = queue.copy();
//		copy.push(321);
		System.out.println(copy.equals(queue));
	}
}
