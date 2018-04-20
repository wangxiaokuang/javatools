package tum0r.test;

import java.util.Iterator;

import tum0r.datastructure.BinaryTree;

public class BinaryTreeTest {
	public static void test() {
		BinaryTree<Integer> root = new BinaryTree<>();
		root.setData(123);
		root.setLeftChildren(456);
		root.setRightChildren(789);
		root.getLeftChildren().setLeftChildren(741);
		root.getLeftChildren().getLeftChildren().setLeftChildren(740);
		root.getLeftChildren().getLeftChildren().setRightChildren(742);
		
		BinaryTree<Integer> copy = root.copy();
//		copy.setData(321);
//		copy.getLeftChildren().setData(321);
		
		// root
		System.out.println("the front sequence is ");
		Iterator iterator = root.frontSequence().iterator();
		while (iterator.hasNext()) {
			System.out.print("[" + iterator.next() + "] ");
		}
		int deep = root.deep();
		System.out.println("\n\ndeep is \n" + deep);
		System.out.println();
		
		// copy
		System.out.println("the front sequence is ");
		iterator = copy.frontSequence().iterator();
		while (iterator.hasNext()) {
			System.out.print("[" + iterator.next() + "] ");
		}
		deep = copy.deep();
		System.out.println("\n\ndeep is \n" + deep);
		
		System.out.println("\n\n"+root.equals(copy));
	}
}
