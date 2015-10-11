package com.paoying.array;

public class OrderedArray {
	
	private int data[];
	
	private int size;
	
	public OrderedArray(int max){
		data = new int[max];
	}
	
	private int innerFind(int key){
		int low = 0;
		int high = size-1;
		while(low <= high){
			int middle = low + (high - low)/2;
			if(data[middle] == key){
				return middle;
			}
			if(data[middle] > key){
				high = middle -1;
			}else{
				low = middle + 1; 
			}
			
		}
		return 0 - low;
		
	}
	
	public void insert(int key){
		int index = innerFind(key);
		if(index < 0){
			index = 0 - index;
		}
		for(int i=size;i>index;i--){
				data[i] = data[i-1];
		}
		data[index] = key;
		size++;
	}
	
	public int find(int key){
		int index = innerFind(key);
		if(index >= 0){
			return index;
		}
		return -1;
	}
	
	public void delete(int key){
		int index = find(key);
		if(index < 0){
			return;
		}
		for(int i=index;i<size;i++){
			data[i] = data[i+1];
		}
		size--;
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
	
	public OrderedArray merge(OrderedArray array){
		OrderedArray result = new OrderedArray(size+array.size);
		int leftIndex = 0;
		int rightIndex = 0;
		for(int i=0;i<size+array.size;i++){
			result.size++;
			if(leftIndex >= size){
				result.data[i] = array.data[rightIndex++];
				continue;
			}
			if(rightIndex>=array.size){
				result.data[i] = data[leftIndex++];
				continue;
			}
			if(data[leftIndex]<array.data[rightIndex]){
				result.data[i] = data[leftIndex++];
			}else{
				result.data[i] = array.data[rightIndex++];
			}
		}
		return result;
	}


}
