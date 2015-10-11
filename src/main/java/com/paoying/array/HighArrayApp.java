package com.paoying.array;

import java.util.Random;

public class HighArrayApp {

	public static void main(String[] args) {
		int maxSize = 20;
//		HighArray reverseOrderArray = SortApp.makeReverseOrderArray(maxSize);
//		reverseOrderArray.display();
//		reverseOrderArray.insertSortNoDup();
//		reverseOrderArray.display();
//		HighArray orderedArray = SortApp.makeOrderedArray(maxSize);
//		orderedArray.display();
//		orderedArray.insertSortNoDup();
//		orderedArray.display();
		HighArray array = makeRandomArray(maxSize);
		array.display();
		array.quickSort();
//		int middle = array.partition(0, 19, array.data[19]);
//		System.out.println("Middle index: "+middle);
		array.display();
//		HighArray array1 = new HighArray(array);
//		array.display();
//		array.shellSort();
//		array.display();
//		array1.insertSort();
//		array1.display();
//		HighArray array = makeRandomArray(maxSize);
//		array.display();
//		array.oddEvenSort();
//		array.display();
//		array.noDupsForOrderedArray();
//		array.display();
//		System.out.println("max num in array: "+array.getMax());
//		array.removeMax();
//		array.display();
//		System.out.println("The median is: "+array.median());
//		array.insertSort();
//		array.display();
//		array.noDups();
//		array.display();
//		array.biDirectionBubbleSort();
//		array.display();
//		HighArray newArray = new HighArray(20);
//		int max = array.getMax();
//		while(max>0){
//			array.removeMax();
//			newArray.insert(max);
//			max = array.getMax();
//		}
//		newArray.display();
//		newArray.bubbleSort();
//		newArray.display();
//		HighArray bigArray = makeRandomArray(10000);
//		bigArray.display();
//		long startTime = System.currentTimeMillis();
//		bigArray.bubbleSort();
//		long endTime = System.currentTimeMillis();
//		System.out.println("Bubble Sort took time: "+(endTime-startTime)+" milliseconds");
//		bigArray.display();
//		HighArray bigArray1 = makeRandomArray(10000);
//		bigArray1.display();
//		startTime = System.currentTimeMillis();
//		bigArray1.selectSort();
//		endTime = System.currentTimeMillis();
//		System.out.println("Select Sort took time: "+(endTime-startTime)+" milliseconds");
//		bigArray1.display();
		
	}

	private static HighArray makeRandomArray(int maxSize) {
		Random rand = new Random();
		HighArray array = new HighArray(maxSize);
		for(int i=0;i<maxSize;i++){
			array.insert(rand.nextInt(maxSize)+1);
		}
		return array;
	}

}
