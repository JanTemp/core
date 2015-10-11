package com.paoying.tree;

public class BinarySearchTree {
	
	private BinaryTreeNode root;
	
	public void insert(String value){
		BinaryTreeNode newNode = new BinaryTreeNode(value);
		if(root == null){
			root = newNode;
			return;
		}
		BinaryTreeNode current = root;
		BinaryTreeNode parent = null;
		boolean isLeft = true;
		while(current !=null){
			String currentValue = current.getData();
			parent = current;
			if(currentValue.compareTo(value)>0){
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
