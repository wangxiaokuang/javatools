package tum0r.datastructure;

import java.util.Iterator;
import java.util.LinkedList;

public class Queue<E> {
	private LinkedList<E> list;

	// back()返回最后一个元素
	//
	// front()返回第一个元素
	public Queue() {
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
			E data = list.getFirst();
			list.removeFirst();
			return data;
		}
		return null;
	}

	public boolean isEmpty() {
		return list.size() == 0;
	}

	public int size() {
		return list.size();
	}

	public E getFront() {
		return list.getFirst();
	}

	public E getBack() {
		return list.getLast();
	}

	public Queue<E> copy() {
		Queue<E> copy = new Queue<>();
		Iterator<E> iterator = list.iterator();
		while (iterator.hasNext()) {
			copy.push(iterator.next());
		}
		return copy;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Queue && this.size() == ((Queue<E>) obj).size()) {
			boolean equals = true;
			Queue<E> thisCopy = this.copy();
			Queue<E> objCopy = ((Queue<E>) obj).copy();
			while(!thisCopy.isEmpty()) {
				if(!thisCopy.pop().equals(objCopy.pop())) {
					return false;
				}
			}
			return true;
		}
		return false;
	}
}
