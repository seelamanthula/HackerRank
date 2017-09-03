package com.divide;

import java.util.Arrays;

/*
 * 	Time Complexity : O(nlog n)
 * 	Space Complexity : It needs 2 auxilary arrays each of size n/2.
 */
		
public class MergeSort {

	public static void main(String[] args) {

		int[] A = {98, 56, 66, 303, 78, 99, 101};
		int p = 0, r = A.length - 1, q = 0;

		MergeSort sort = new MergeSort();
		sort.divide(A, p, r);
	}
	
	void divide(int[] arr, int p, int r){
		if(p < r){
			int q = (p + r) / 2;
			divide(arr, p, q);
			divide(arr, q + 1, r);
			merge2(arr, p, q, r);
		}	
	}

	// Creating 1 different sub arrays with 2 different pointers to it

	void merge(int[] arr, int p, int q, int r){
		int[] cp = new int[arr.length];
		for (int i = p; i <= r; i++) {
			cp[i] = arr[i];
		}
		
		int l = p,
			m = q + 1,
			curr = p;
		
		while (l <= q && m <= r) {
			if(cp[l] <= cp[m]){
				arr[curr] = cp[l];
				l++;
				
			} else {
				arr[curr] = cp[m];
				m++;
			}
			curr++;		
		}
		
		int x = q - l;
		for (int i = 0; i <= x; i++) {
			arr[curr + i] = cp[l + i];
		}
		
		System.out.println(Arrays.toString(arr));
		
	}

	// Creating 2 different sub arrays
	void merge2(int[] arr, int p, int q, int r){

		int l = 0,
			m = 0,
			curr = p;

		int n1 = q + 1 - p, n2 = r - q;
		
		int[] b1 = new int[n1];
		int[] b2 = new int[n2];
		
		for(int i = 0; i < n1; i++) {
			b1[i] = arr[p + i];
		}
		
		for(int i = 0; i < n2; i++) {
			b2[i] = arr[q + 1 + i];
		}

		while (l < n1 && m < n2) {
			if(b1[l] <= b2[m]){
				arr[curr] = b1[l];
				l++;
				
			} else {
				arr[curr] = b2[m];
				m++;
			}
			curr++;		
		}
		
		while(l < n1) {
			arr[curr] = b1[l];
			l = l + 1;
			curr = curr + 1;
		}

		while(m < n2) {
			arr[curr] = b2[m];
			m = m + 1;
			curr = curr + 1;
		}
	
		System.out.println(Arrays.toString(arr));		
	}

}
