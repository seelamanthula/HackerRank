package arrays;

import java.util.Scanner;

public class CircularRotation {

	public static void main(String[] args) {
		  
			Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int k = in.nextInt();
	        int q = in.nextInt();
	        int[] a = new int[n];
	        for(int a_i=0; a_i < n; a_i++){
	            a[a_i] = in.nextInt();
	        }
	        int[] qu = new int[q];
	        for(int a0 = 0; a0 < q; a0++){
	            int m = in.nextInt();
	           // Sysout
	            qu[a0] = m;
	        }
	        
	       int[] b = new int[k];
	       for(int i = n - k, j = 0; i < n; i++, j++)
	    	   b[j] = a[i];
	       
	       System.out.print("\nAAA");
	       for(int i  = 0; i < k; i++)
	    	   System.out.print(" "+b[i]);
	       
	       for(int i = n - 1; i >= k; i--)
	    	   a[i] = a[i-k];	       

	       System.out.print("\nBBB");
	       for(int i  = 0; i < n; i++)
	    	   System.out.print(" "+a[i]);
	       
	       for(int i = 0; i < k; i++)
	    	   a[i] = b[i];
	       
	       System.out.println("\nCCC");
	        for(int a0 = 0; a0 < q; a0++){
	            System.out.println(a[qu[a0]]);
	        }
	}
}
