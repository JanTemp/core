package com.paoying.tree;

import java.util.Arrays;

public class BinarySearchTreeTest {
	public static void main(String[] args){
		BinarySearchTree tree = new BinarySearchTree();
		int[] values = new int[20];
		for(int i=0;i<20;i++){
			int value = (int)(Math.random()*100);
			tree.insert(value);
			values[i] = value;
		}
		System.out.println(Arrays.toString(values));
		tree.inOrderTraverse();
		System.out.println();
		System.out.println("Search for "+values[10]+" and found: "+tree.find(values[10]));
		System.out.println("Search for "+101+" and found: "+tree.find(101));
		System.out.println("Delete "+values[3]+"...");
		tree.delete(values[3]);
		tree.inOrderTraverse();
		System.out.println("\nDelete "+values[9]+"...");
		tree.delete(values[9]);
		tree.inOrderTraverse();
		System.out.println("\nDelete "+values[15]+"...");
		tree.delete(values[15]);
		tree.inOrderTraverse();
	}
}
