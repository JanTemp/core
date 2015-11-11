package com.paoying.tree;

public class BinarySearchTree {

	private BinaryTreeNode root;

	public void insert(int value) {
		BinaryTreeNode newNode = new BinaryTreeNode(value);
		if (root == null) {
			root = newNode;
			return;
		}
		BinaryTreeNode current = root;
		BinaryTreeNode parent = null;
		boolean isLeft = true;
		while (current != null) {
			int currentValue = current.getData();
			parent = current;
			if (value < currentValue) {
				current = current.getLeftChild();
				isLeft = true;
			} else {
				current = current.getRightChild();
				isLeft = false;
			}
		}
		if (isLeft) {
			parent.setLeftChild(newNode);
		} else {
			parent.setRightChild(newNode);
		}
	}

	public BinaryTreeNode find(int value) {
		BinaryTreeNode current = root;
		while (true) {
			if (current == null || value == current.getData()) {
				return current;
			}
			if (value < current.getData()) {
				current = current.getLeftChild();
			} else {
				current = current.getRightChild();
			}
		}
	}

	public void delete(int value) {
		// search for delete
		BinaryTreeNode current = root;
		BinaryTreeNode parent = null;
		boolean isLeft = true;
		while (current != null && current.getData() != value) {
			parent = current;
			if (value < current.getData()) {
				current = current.getLeftChild();
				isLeft = true;
			} else {
				current = current.getRightChild();
				isLeft = false;
			}
		}
		if (current == null) {
			return;
		}
		if (current.getLeftChild() == null || current.getRightChild() == null) {
			if (parent == null) {
				root = current.getLeftChild() == null ? current.getRightChild()
						: current.getLeftChild();
				return;
			}
			if (isLeft) {
				parent.setLeftChild(current.getLeftChild() == null ? current
						.getRightChild() : current.getLeftChild());
			} else {
				parent.setRightChild(current.getLeftChild() == null ? current
						.getRightChild() : current.getLeftChild());
			}
			return;
		}
		// if current has more than one child, find its successor first
		BinaryTreeNode successor = detachSuccessor(current);
		successor.setLeftChild(current.getLeftChild());
		if (parent == null) {
			root = successor;
		} else {
			if (isLeft) {
				parent.setLeftChild(successor);
			} else {
				parent.setRightChild(successor);
			}
		}
		if (successor != current.getRightChild()) {
			successor.setRightChild(current.getRightChild());
		}
	}

	private BinaryTreeNode detachSuccessor(BinaryTreeNode toBeDeleted) {
		BinaryTreeNode current = toBeDeleted.getRightChild();
		BinaryTreeNode parent = toBeDeleted;
		while (current.getLeftChild() != null) {
			parent = current;
			current = current.getLeftChild();
		}
		if (parent != toBeDeleted) {
			parent.setLeftChild(current.getRightChild());
		}
		return current;
	}

	public void inOrderTraverse() {
		recInOrderTraverse(root);
	}

	private void recInOrderTraverse(BinaryTreeNode subRoot) {
		if (subRoot == null) {
			return;
		}
		recInOrderTraverse(subRoot.getLeftChild());
		System.out.print(subRoot.getData() + " ");
		recInOrderTraverse(subRoot.getRightChild());
	}

	public BinaryTreeNode getRoot() {
		return root;
	}

	public void setRoot(BinaryTreeNode root) {
		this.root = root;
	}
	
	
}
