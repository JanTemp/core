package com.paoying.tree;

public class BinaryTreeNode {
	
	private int data;
	
	private BinaryTreeNode leftChild;
	
	private BinaryTreeNode rightChild;
	
	public BinaryTreeNode(int data){
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public BinaryTreeNode getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(BinaryTreeNode leftChild) {
		this.leftChild = leftChild;
	}

	public BinaryTreeNode getRightChild() {
		return rightChild;
	}

	public void setRightChild(BinaryTreeNode rightChild) {
		this.rightChild = rightChild;
	}
	
	public String toString(){
		return ""+data;
	}

}
