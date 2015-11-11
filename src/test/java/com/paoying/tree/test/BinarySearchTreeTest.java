package com.paoying.tree.test;

import static org.junit.Assert.*;

import org.junit.After;

import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;

import com.paoying.tree.BinarySearchTree;
import com.paoying.tree.BinaryTreeNode;

public class BinarySearchTreeTest {
	
	private static int[] values = {19, 31, 12, 17, 23, 82, 56, 77, 29, 35};
	
	private BinarySearchTree tree;
	
	@Before
	public void init(){
		tree = new BinarySearchTree();
	}

	@Test
	public void insertOrderedTree() {
		for(int i=0;i<10;i++){
			tree.insert(i);
		}
		
		BinaryTreeNode node = tree.getRoot();
		for(int i=0;i<10;i++){
			assertThat(i, equalTo(node.getData()));
			node = node.getRightChild();
		}
	}
	
	@Test
	public void findInEmptyTree(){
		BinaryTreeNode node = tree.find(5);
		
		assertThat(node, is(nullValue()));
	}
	
	@Test
	public void deleteInEmptyTree(){
		tree.delete(5);
		
		assertThat(tree.getRoot(),is(nullValue()));
	}
	
	@Test
	public void insertRandomValues(){
		generateRandomTree();
		
		for(int value: values){
			assertThat(tree.find(value), is(notNullValue()));
		}
		
		assertThat(tree.find(99), is(nullValue()));
	}

	private void generateRandomTree() {
		
		for(int value: values){
			tree.insert(value);
		}
	}
	
	@Test
	public void deleteRandomValue(){
		generateRandomTree();
		
		int value = values[3];
		tree.delete(value);
		
		assertThat(tree.find(value), is(nullValue()));
	}
	
	@Test
	public void deleteRoot(){
		generateRandomTree();
		
		int rootValue = tree.getRoot().getData();
		tree.delete(rootValue);
		
		assertThat(tree.find(rootValue), is(nullValue()));
		assertThat(tree.find(values[2]), is(notNullValue()));
	}
	
	@Test
	public void deleteLeaf(){
		generateRandomTree();
		
		tree.delete(35);
		
		assertThat(tree.find(35), is(nullValue()));
	}
	
	@Test
	public void deleteNonLeaf(){
		generateRandomTree();
		
		tree.delete(31);
		
		assertThat(tree.find(31), is(nullValue()));
	}
	
	@Test
	public void insertDuplicates(){
		for(int i=0;i<10;i++){
			tree.insert(5);
		}
		assertThat(tree.find(5), is(notNullValue()));
	}
	
	@After
	public void checkInvariant(){
		BinaryTreeNode node = tree.getRoot();
		checkInvariant(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	private void checkInvariant(BinaryTreeNode node, int lowLimit, int highLimit){
		if(node == null){
			return;
		}
		if(node.getLeftChild()!=null){
			assertThat(node.getLeftChild().getData(), is(lessThan(node.getData())));
			assertThat(node.getLeftChild().getData(), is(greaterThanOrEqualTo(lowLimit)));
		}
		if(node.getRightChild()!=null){
			assertThat(node.getRightChild().getData(), is(greaterThanOrEqualTo(node.getData())));
			assertThat(node.getRightChild().getData(), is(lessThan(highLimit)));
		}
		checkInvariant(node.getLeftChild(), lowLimit, node.getData());
		checkInvariant(node.getRightChild(), node.getData(), highLimit);
		
	}

}
