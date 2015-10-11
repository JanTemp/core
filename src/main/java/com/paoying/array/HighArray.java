package com.paoying.array;

import java.util.Stack;


public class HighArray {
	
	int[] data;
	
	private int size;
	
	public HighArray(int max){
		data = new int[max];
		size = 0;
	}
	
	public HighArray(HighArray array){
		data = new int[array.data.length];
		for(int i=0;i<array.size;i++){
			data[i] = array.data[i];
		}
		size = array.size;
	}
	
	public void insert(int num){
		data[size] = num;
		size++;
	}
	
	public int find(int searchKey){
		for(int i=0;i<size;i++){
			if(data[i] == searchKey){
				return i;
			}
		}
		return -1;
	}
	
	public int delete(int searchKey){
		int indexOfSearchKey = find(searchKey);
		if(indexOfSearchKey>=0){
			for(int i=indexOfSearchKey;i<size-1;i++){
				data[i] = data[i+1];
			}
			size--;
		}
		return indexOfSearchKey;
	}
	
	public int getMax(){
		int max = -1;
		for(int i=0;i<size;i++){
			if(data[i]>max){
				max = data[i];
			}
		}
		return max;
	}
	
	public void removeMax(){
		int max = getMax();
		if(max>0){
			delete(max);
		}
	}
	
	public void noDups(){
		HighArray keys = new HighArray(size);
		HighArray toBeDeleted = new HighArray(size);
		for(int i=0;i<size;i++){
			int index = keys.find(data[i]);
			keys.insert(data[i]);
			if(index >= 0){
				toBeDeleted.insert(i);
			}
		}
		int max = toBeDeleted.getMax();
		while(max >= 0){
			for(int i=max;i<size;i++){
				data[i] = data[i+1];
			}
			size--;
			toBeDeleted.removeMax();
			max = toBeDeleted.getMax();
		}
	}
	
	public void noDupsForOrderedArray(){
		int lastNonDupIndex = 0;
		int dupCount = 0;
		for(int i=1;i<size;i++){
			if(data[i] == data[lastNonDupIndex]){
				dupCount++;
			}else{
				data[++lastNonDupIndex] = data[i];
			}
		}
		size = size - dupCount;
	}
	
	public void display(){
		System.out.print("[");
		for(int i=0;i<size;i++){
			System.out.print(data[i]);
			if(i<size-1){
				System.out.print(",");
			}
		}
		System.out.println("]");
	}
	
	public void bubbleSort(){
		for(int out=size-1;out>0;out--){
			for(int in=0;in<out;in++){
				if(data[in]>data[in+1]){
					swap(in,in+1);
				}
			}
		}
	}
	
	public void biDirectionBubbleSort(){
		int leftOut=0;
		int rightOut=size-1;
		while(leftOut<rightOut){
			for(int in=leftOut;in<rightOut;in++){
				if(data[in]>data[in+1]){
					swap(in, in+1);
				}
			}
			rightOut--;
			for(int in=rightOut;in>leftOut;in--){
				if(data[in-1]>data[in]){
					swap(in, in-1);
				}
			}
			leftOut++;
		}
		
	}
	
	private void swap(int left, int right){
		int value = data[left];
		data[left] = data[right];
		data[right] = value;
//		System.out.print("After swap: ");
//		display();
	}
	
	public void selectSort(){
		int minIndex, out, in;
		for(out=0;out<size-1;out++){
			minIndex = out;
			for(in=out;in<size;in++){
				if (data[in]<data[minIndex]){
					minIndex = in;
				}
			}
			swap(out, minIndex);
		}
	}
	
	public void insertSort(){
//		int compareCount = 0;
//		int copyCount = 0;
		for(int out=1;out<size;out++){
			int temp = data[out];
			int in = out;
			while(in>0){
				if(data[in-1]>temp){
					data[in] = data[in-1];
					in--;
//					compareCount++;
//					copyCount++;
				}else{
//					compareCount++;
					break;
				}
				
			}
			data[in] = temp;
		}
//		System.out.println("compare count: "+compareCount);
//		System.out.println("copy count: "+copyCount);
	}
	

	
	public int median(){
		HighArray copy = new HighArray(this);
		copy.insertSort();
		return copy.data[copy.size/2];
	}
	
	public void oddEvenSort(){
		for(int i=0;i<size/2;i++){
			for(int oddIn=0;oddIn<size-1;oddIn+=2){
				if(data[oddIn]>data[oddIn+1]){
					swap(oddIn, oddIn+1);
				}
			}
			display();
			for(int evenIn=1;evenIn<size-1;evenIn+=2){
				if(data[evenIn]>data[evenIn+1]){
					swap(evenIn, evenIn+1);
				}
			}
			display();
		}
	}
	
	
	public void insertSortNoDup(){
		for(int out=1;out<size;out++){
			int temp = data[out];
			int in = out-1;
			while(in>=0 && data[in]>=temp){
				data[in+1] = data[in];
				if(data[in]==temp){
					temp=-1;
				}
				in--;
			}
			data[in+1] = temp;
		}
		int validCount = 0;
		for(int i=0, lastHole=0;i<size;i++){
			if(data[i]>-1){
				data[lastHole++] = data[i];
				validCount++;
			}
		}
		size = validCount;
	}
	
	public void mergeSort(){
		mergeSort(0, size-1);
	}
	
	private void mergeSort(int from, int to){
		if(from >= to){
			return;
		}else{
			mergeSort(from, (to+from)/2);
			mergeSort((to+from)/2+1, to);
			merge(from, (to+from)/2, to);
		}
	}
	
	private void merge(int from1, int to1, int to2){
//		System.out.println(from1+","+to1+","+to2);
		int from2 = to1+1;
		int in1 = from1;
		int in2 = from2;
		int[] temp = new int[to2-from1+1];
		int in3 = 0;
		while(in1<=to1&&in2<=to2){
			if(data[in1]<data[in2]){
				temp[in3++] = data[in1++];
			}else{
				temp[in3++] = data[in2++];
			}
		}
		while(in1<=to1){
			temp[in3++] = data[in1++];
		}
		while(in2<=to2){
			temp[in3++] = data[in2++];
		}
		in3 = 0;
		for(int i=from1;i<=to2;i++){
			data[i] = temp[in3++];
		}
	}
	
	public void shellSort(){
		Stack<Integer> gapStack = calculateGaps();
		while(!gapStack.isEmpty()){
			int gap = gapStack.pop();
			for(int out = gap;out<size;out++){
				int temp = data[out];
				int in = out;
				while(in>=gap && data[in-gap]>temp){
					data[in] = data[in-gap];
					in = in - gap;
				}
				data[in] = temp;
			}
		}
	}

	private Stack<Integer> calculateGaps() {
		Stack<Integer> gapStack = new Stack<>();
		int gap = 1;
		while(gap<size){
			gapStack.push(gap);
			gap = gap*3 + 1;
		}
		return gapStack;
	}
	
	public int partition(int left, int right, int pivot){
		int leftScan = left;
		int rightScan = right;
		while(true){
			while(leftScan < right && data[leftScan] < pivot){
				leftScan++;
			}
			while(rightScan > left && data[rightScan] > pivot){
				rightScan--;
			}
			if(leftScan >= rightScan){
//				display();
//				System.out.println(leftScan);
				return leftScan;
			}
			swap(leftScan++, rightScan--);
		}
		
	}
	
	public void quickSort(){
		recQuickSort(0, size-1);
	}

	private void recQuickSort(int left, int right) {
		if(left >= right){
			return;
		}
		int middle = partition(left, right-1, data[right]);
		if(data[middle] > data[right]){
			swap(middle, right);
		}
		display();
		System.out.println(left+", "+middle+", "+right+", "+data[middle]);
		recQuickSort(left, middle-1);
		recQuickSort(middle+1, right);
		
	}

}
