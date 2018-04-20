package tum0r.datastructure;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree<E> {
	private BinaryTree<E> left;
	private BinaryTree<E> right;
	private BinaryTree<E> root;
	private E data;
	private static final int FRONT = 1000;
	private static final int CENTER = 1001;
	private static final int LAST = 1002;

	public BinaryTree() {
		left = null;
		right = null;
		setData(null);
	}

	public void setData(E data) {
		this.data = data;
	}

	public void setLeftChildren(E data) {
		left = new BinaryTree<>();
		left.setData(data);
		left.root = this;
	}

	public void setRightChildren(E data) {
		right = new BinaryTree<>();
		right.setData(data);
		right.root = this;
	}

	public BinaryTree<E> getLeftChildren() {
		return left;
	}

	public BinaryTree<E> getRightChildren() {
		return right;
	}

	public BinaryTree<E> getRoot() {
		return root;
	}

	public E getData() {
		return data;
	}

	public List<E> frontSequence() {
		return getSequence(this, FRONT);
	}

	public List<E> centerSequence() {
		return getSequence(this, CENTER);
	}

	public List<E> lastSequence() {
		return getSequence(this, LAST);
	}

	private List<E> getSequence(BinaryTree<E> root, int type) {
		List<E> result = new ArrayList<>();
		BinaryTree<E> tempLeft = root.getLeftChildren();
		BinaryTree<E> tempRight = root.getRightChildren();
		if (root != null) {
			if (type == FRONT) {
				result.add(root.getData());
			}
			if (tempLeft.getData() != null) {
				result.addAll(getSequence(tempLeft, type));
			}
			if (type == CENTER) {
				result.add(root.getData());
			}
			if (tempRight.getData() != null) {
				result.addAll(getSequence(tempRight, type));
			}
			if (type == LAST) {
				result.add(root.getData());
			}
		}
		return result;
	}

	public int deep() {
		return getDeep(this);
	}

	private int getDeep(BinaryTree<E> root) {
		int length = 1;
		int leftLength = 0;
		int rightLength = 0;
		if (root.getLeftChildren() != null) {
			leftLength += getDeep(root.getLeftChildren());
		}
		if (root.getRightChildren() != null) {
			rightLength += getDeep(root.getRightChildren());
		}
		length += leftLength > rightLength ? leftLength : rightLength;
		return length;
	}

	public BinaryTree<E> copy() {
		BinaryTree<E> copy = new BinaryTree<>();
		copy(this, copy);
		return copy;
	}

	private void copy(BinaryTree<E> root, BinaryTree<E> copy) {
		copy.setData(root.getData());
		BinaryTree<E> left = root.getLeftChildren();
		BinaryTree<E> right = root.getRightChildren();
		if (left != null) {
			copy.setLeftChildren(null);
			copy(left, copy.getLeftChildren());
		}
		if (right != null) {
			copy.setRightChildren(null);
			copy(right, copy.getRightChildren());
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof BinaryTree && this.deep() == ((BinaryTree<E>) obj).deep()) {
			return equals(this, (BinaryTree<E>) obj);
		}
		return false;
	}

	private boolean equals(BinaryTree<E> binaryTree1, BinaryTree<E> binaryTree2) {
		boolean equals = true;
		if (binaryTree1 != null) {
			if (binaryTree1.equals(binaryTree2.getData())) {
				equals = equals(binaryTree1.getLeftChildren(), binaryTree2.getLeftChildren());
				if (!equals) {
					return false;
				}
				equals = equals(binaryTree1.getRightChildren(), binaryTree2.getRightChildren());
			} else {
				equals = false;
			}
		} else if (binaryTree2 != null) {
			if (binaryTree2.equals(binaryTree1.getData())) {
				equals = equals(binaryTree1.getLeftChildren(), binaryTree2.getLeftChildren());
				if (!equals) {
					return false;
				}
				equals = equals(binaryTree1.getRightChildren(), binaryTree2.getRightChildren());
			} else {
				equals = false;
			}
		}
		return equals;
	}
}
