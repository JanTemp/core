package com.paoying.tree;

public class BinarySearchTree {
	
	private BinaryTreeNode root;
	
	public void insert(int value){
		BinaryTreeNode newNode = new BinaryTreeNode(value);
		if(root == null){
			root = newNode;
			return;
		}
		BinaryTreeNode current = root;
		BinaryTreeNode parent = null;
		boolean isLeft = true;
		while(current !=null){
			int currentValue = current.getData();
			parent = current;
			if(value < currentValue){
				current = current.getLeftChild();
				isLeft = true;
			}else{
				current = current.getRightChild();
				isLeft = false;
			}
		}
		if(isLeft){
			parent.setLeftChild(newNode);
		}else{
			parent.setRightChild(newNode);
		}
	}
	
	public BinaryTreeNode find(int value){
		BinaryTreeNode current = root;
		while(true){
			if(current == null || value == current.getData()){
				return current;
			}
			if(value < current.getData()){
				current = current.getLeftChild();
			}else{
				current = current.getRightChild();
			}
		}
	}
	
	public void inOrderTraverse(){
		recInOrderTraverse(root);
	}

	private void recInOrderTraverse(BinaryTreeNode subRoot) {
		if(subRoot == null){
			return;
		}
		recInOrderTraverse(subRoot.getLeftChild());
		System.out.print(subRoot.getData()+" ");
		recInOrderTraverse(subRoot.getRightChild());
	}
}
