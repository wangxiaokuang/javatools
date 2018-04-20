package tum0r.datastructure;

import java.util.Iterator;
import java.util.LinkedList;

public class Stack<E> {
	private LinkedList<E> list;

	public Stack() {
		list = new LinkedList<>();
	}

	public boolean push(E data) {
		if (list.size() < Integer.MAX_VALUE) {
			list.addLast(data);
			return true;
		}
		return false;
	}

	public E pop() {
		if (list.size() > 0) {
			E data = list.getLast();
			list.removeLast();
			return data;
		}
		return null;
	}

	public int size() {
		return list.size();
	}

	public boolean isEmpty() {
		return list.size() == 0;
	}

	public E top() {
		return list.getLast();
	}

	public Stack<E> copy() {
		Stack<E> copy = new Stack<>();
		Iterator<E> iterator = list.iterator();
		while (iterator.hasNext()) {
			copy.push(iterator.next());
		}
		return copy;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Stack && this.size() == ((Stack<E>) obj).size()) {
			Stack<E> thisCopy = this.copy();
			Stack<E> objCopy = ((Stack<E>) obj).copy();
			while (!thisCopy.isEmpty()) {
				if (!thisCopy.pop().equals(objCopy.pop())) {
					return false;
				}
			}
			return true;
		}
		return false;
	}
}
