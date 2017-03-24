package sortings;

import java.util.Scanner;

public class QuickSort {

	static int[] arr;
	
	static int lomotoPartition(int low, int high) {
		int x = arr[high];
		int i = low;     // place for swapping
		for(int j = low; j <= (high-1); j++) {
	        if(arr[j] <= x)  {
	            swap(i, j);           
	            i = i + 1;
	        }
		}
		swap(i, high);         
		return i;
	}
	
	static int partition(int low, int high)
    {
       int x = arr[low];
       int j = low + 1;
       int i = high;
       
		 /*int x = arr[high];
	       int j = high - 1;
	       int i = low;*/
       while(true) {
    	   
    	   while(x > arr[j] && j < high) { j++; }
    	   
    	   while(x < arr[i] && i > low) { i--; }
    	   
    	   if(i > j) {
    		   swap(i, j);
    	//	   printArray(0, arr.length - 1);
    	   }
    	   else {
    		   swap(i, low);
    		 //  printArray(0, arr.length - 1);
    		   return j - 1;
    	   }
       }
		
    }
 
    static int[] swap(int a, int b) {
    	int temp = arr[a];
    	arr[a] = arr[b];
    	arr[b] = temp;
    	return arr;
    }
	
	    static void sort(int p, int r) {
	        if(p < r) {
	            int q = lomotoPartition(p,  r);
	            printArray(0, arr.length - 1);
	            sort(p, q - 1);
	              sort(q + 1, r);
	        }
	       // printArray(p, r);
	    }
	    
       static void quickSort(int[] ar) {  
    	   arr = ar;
           sort(0, ar.length - 1);
           System.out.println("Sorted..");
           printArray(0, arr.length - 1);
       }   
 
      static void printArray(int p, int r) {
    	//  System.out.println("P : "+p+" R : "+r);
         for(int i = p; i <= r; i++){
            System.out.print(arr[i]+" ");
         }
           System.out.println("");
      }
       
      public static void main(String[] args) {
           Scanner in = new Scanner(System.in);
           int n = in.nextInt();
           int[] ar = new int[n];
           for(int i=0;i<n;i++){
              ar[i]=in.nextInt(); 
           }
           quickSort(ar);
       }    

}
