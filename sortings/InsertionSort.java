package sortings;

import java.util.Scanner;

public class InsertionSort {

	public static void insertionSortPart2(int[] ar)
    {       
           // Fill up the code for the required logic here
           // Manipulate the array as required
           // The code for Input/Output is already provided
        
        int temp, j;
        int n = ar.length;
        
      //  printArray(ar);
        for(int i = 1; i < n; i++) {
            temp = ar[i];
            j = i - 1;
            while(j >= 0 && temp < ar[j]) {
                ar[j + 1] = ar[j];
                j--;
            }
            ar[j + 1] = temp;
            printArray(ar);
        }
    }  
    
    
      
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
       int s = in.nextInt();
       int[] ar = new int[s];
       for(int i=0;i<s;i++){
            ar[i]=in.nextInt(); 
       }
       insertionSortPart2(ar);    
                    
    }    
    private static void printArray(int[] ar) {
      for(int n: ar){
         System.out.print(n+" ");
      }
        System.out.println("");
   }

}
