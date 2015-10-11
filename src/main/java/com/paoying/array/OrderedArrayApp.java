package com.paoying.array;

import java.util.Random;

public class OrderedArrayApp {
	public static void main(String[] args){
		OrderedArray array = generateArray();
		int key = 7;
		int index = array.find(key);
		if(index >= 0){
			System.out.println("Found "+ key + " at "+index);
		}else{
			System.out.println("Cannot find key: "+key);
		}
		array.delete(key);
		array.display();
		OrderedArray array1 = generateArray();
		OrderedArray array2 = generateArray();
		array1.display();
		array2.display();
		array1.merge(array2).display();
	}

	private static OrderedArray generateArray() {
		Random rand = new Random();
		OrderedArray array = new OrderedArray(20);
		for(int i=0;i<10;i++){
			array.insert(rand.nextInt(20)+1);
//			array.display();
		}
		return array;
	}

}
