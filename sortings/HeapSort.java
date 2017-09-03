package com.divide;

import java.util.Arrays;

/*
 *  Invented by: John William Joseph Williams in 1964
 * 
 * 	Time Complexity : O(n log n)
 * 	Space Complexity :  an in-place algorithm
 * 	
 * 	Not a Stable Sort 
 */
		

public class HeapSort {

	public static void main(String[] args) {
		
		int[] A = {98, 56, 66, 303, 78, 99, 101};

		HeapSort sort = new HeapSort();
		sort.buildHeap(A);
	}
	

	void buildHeap(int[] arr) {
		
		System.out.println("In : "+Arrays.toString(arr));
		
		for(int i = (arr.length/2) - 1; i >= 0; i--) {
			heapify(arr, arr.length, i);
		}

		int n = arr.length;
	    while(n > 0)  {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[n - 1];
            arr[n - 1] = temp;
 
            // call max heapify on the reduced heap
            heapify(arr, n - 1, 0);
            n = n - 1;
        }

	    System.out.println("Out : "+Arrays.toString(arr));
	}
	
	void heapify(int[] arr, int n, int i) {
		
		int parent = i,
			left = (2 * i) + 1,
			right = (2 * i) + 2, large = parent;
		
		if(left < n && arr[large] < arr[left]) {
			large = left;
		} 
		
		if(right < n && arr[large] < arr[right])
			large = right;
	
		System.out.println(Arrays.toString(arr));
		
		if(large != parent) {
			int k = arr[parent];
			arr[parent] = arr[large];
			arr[large] = k;

			heapify(arr, n, large);
		}
		
		
	}
}
