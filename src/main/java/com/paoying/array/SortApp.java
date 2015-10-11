package com.paoying.array;

import java.util.Random;

public class SortApp {
	public static void main(String[] args){
//		bubbleSort(100000);
//		selectSort(100000);
		insertSort(100000);
		shellSort(100000);
	}
	
	
	private static void bubbleSort(int arraySize){
		HighArray reverseOrderArray = makeReverseOrderArray(arraySize);
//		reverseOrderArray.display();
		long startTime = System.currentTimeMillis();
		reverseOrderArray.bubbleSort();
		long endTime = System.currentTimeMillis();
		System.out.println("Bubble Sort took time for reverse order array: "+(endTime-startTime)+" milliseconds");
//		reverseOrderArray.display();
		
		HighArray array = makeRandomArray(arraySize);
//		array.display();
		startTime = System.currentTimeMillis();
		array.bubbleSort();
		endTime = System.currentTimeMillis();
		System.out.println("Bubble Sort took time: "+(endTime-startTime)+" milliseconds");
//		array.display();

		
		HighArray orderedArray = makeOrderedArray(arraySize);
//		reverseOrderArray.display();
		startTime = System.currentTimeMillis();
		orderedArray.bubbleSort();
		endTime = System.currentTimeMillis();
		System.out.println("Bubble Sort took time for ordered array: "+(endTime-startTime)+" milliseconds");
//		reverseOrderArray.display();
	}
	
	public static HighArray makeReverseOrderArray(int arraySize) {
		HighArray result = new HighArray(arraySize);
		for(int i=0;i<arraySize;i++){
			result.insert(arraySize-i);
		}
		return result;
	}

	public static HighArray makeOrderedArray(int arraySize) {
		HighArray result = new HighArray(arraySize);
		for(int i=0;i<arraySize;i++){
			result.insert(i+1);
		}
		return result;
	}


	private static void selectSort(int arraySize){
		HighArray reverseOrderArray = makeReverseOrderArray(arraySize);
//		reverseOrderArray.display();
		long startTime = System.currentTimeMillis();
		reverseOrderArray.selectSort();
		long endTime = System.currentTimeMillis();
		System.out.println("Select Sort took time for reverse order array: "+(endTime-startTime)+" milliseconds");
//		reverseOrderArray.display();
		
		HighArray array = makeRandomArray(arraySize);
//		array.display();
		startTime = System.currentTimeMillis();
		array.selectSort();
		endTime = System.currentTimeMillis();
		System.out.println("Select Sort took time: "+(endTime-startTime)+" milliseconds");
//		array.display();

		
		HighArray orderedArray = makeOrderedArray(arraySize);
//		reverseOrderArray.display();
		startTime = System.currentTimeMillis();
		orderedArray.selectSort();
		endTime = System.currentTimeMillis();
		System.out.println("Select Sort took time for ordered array: "+(endTime-startTime)+" milliseconds");
//		reverseOrderArray.display();
	}
	
	private static void insertSort(int arraySize){
		HighArray array = makeRandomArray(arraySize);
//		array.display();
		long startTime = System.currentTimeMillis();
		array.insertSort();
		long endTime = System.currentTimeMillis();
		System.out.println("Insert Sort took time: "+(endTime-startTime)+" milliseconds");
//		array.display();
		
		HighArray reverseOrderArray = makeReverseOrderArray(arraySize);
//		reverseOrderArray.display();
		startTime = System.currentTimeMillis();
		reverseOrderArray.insertSort();
		endTime = System.currentTimeMillis();
		System.out.println("Insert Sort took time for reverse order array: "+(endTime-startTime)+" milliseconds");
//		reverseOrderArray.display();
		
		HighArray orderedArray = makeOrderedArray(arraySize);
//		reverseOrderArray.display();
		startTime = System.currentTimeMillis();
		orderedArray.insertSort();
		endTime = System.currentTimeMillis();
		System.out.println("Insert Sort took time for ordered array: "+(endTime-startTime)+" milliseconds");
//		reverseOrderArray.display();
	}
	
	private static HighArray makeRandomArray(int maxSize) {
		Random rand = new Random();
		HighArray array = new HighArray(maxSize);
		for(int i=0;i<maxSize;i++){
			array.insert(rand.nextInt(maxSize)+1);
		}
		return array;
	}
	
	private static void mergeSort(int arraySize){
		HighArray array = makeRandomArray(arraySize);
//		array.display();
		long startTime = System.currentTimeMillis();
		array.mergeSort();
		long endTime = System.currentTimeMillis();
		System.out.println("Merge Sort took time: "+(endTime-startTime)+" milliseconds");
//		array.display();
		
		HighArray reverseOrderArray = makeReverseOrderArray(arraySize);
//		reverseOrderArray.display();
		startTime = System.currentTimeMillis();
		reverseOrderArray.mergeSort();
		endTime = System.currentTimeMillis();
		System.out.println("Merge Sort took time for reverse order array: "+(endTime-startTime)+" milliseconds");
//		reverseOrderArray.display();
		
		HighArray orderedArray = makeOrderedArray(arraySize);
//		reverseOrderArray.display();
		startTime = System.currentTimeMillis();
		orderedArray.mergeSort();
		endTime = System.currentTimeMillis();
		System.out.println("Merge Sort took time for ordered array: "+(endTime-startTime)+" milliseconds");
//		reverseOrderArray.display();
	}
	
	private static void shellSort(int arraySize){
		HighArray array = makeRandomArray(arraySize);
//		array.display();
		long startTime = System.currentTimeMillis();
		array.shellSort();
		long endTime = System.currentTimeMillis();
		System.out.println("Shell Sort took time: "+(endTime-startTime)+" milliseconds");
//		array.display();
		
		HighArray reverseOrderArray = makeReverseOrderArray(arraySize);
//		reverseOrderArray.display();
		startTime = System.currentTimeMillis();
		reverseOrderArray.shellSort();
		endTime = System.currentTimeMillis();
		System.out.println("Shell Sort took time for reverse order array: "+(endTime-startTime)+" milliseconds");
//		reverseOrderArray.display();
		
		HighArray orderedArray = makeOrderedArray(arraySize);
//		reverseOrderArray.display();
		startTime = System.currentTimeMillis();
		orderedArray.shellSort();
		endTime = System.currentTimeMillis();
		System.out.println("Shell Sort took time for ordered array: "+(endTime-startTime)+" milliseconds");
//		reverseOrderArray.display();
	}
}
