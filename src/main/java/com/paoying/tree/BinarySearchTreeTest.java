package com.paoying.tree;

import java.util.Arrays;

public class BinarySearchTreeTest {
	public static void main(String[] args){
		BinarySearchTree tree = new BinarySearchTree();
		String[] values = new String[20];
		for(int i=0;i<20;i++){
			String value = "" + (int)(Math.random()*100);
			tree.insert(value);
			values[i] = value;
		}
		System.out.println(Arrays.toString(values));
		tree.inOrderTraverse();
	}
}
