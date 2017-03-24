package arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class LeftRotation {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
	        long n = sc.nextLong();
	        long d = sc.nextLong();
	        
	        ArrayList<Long> a = new ArrayList<Long>();
	        for(long i = 0; i < n; i++) {
	            a.add(sc.nextLong());
	        }
	        
	        for(long i = d-1; i < n ; i++)
	            System.out.print(a.get((int) i)+" ");
	        
	        for(long i = 0; i < d; i++)
	            System.out.print(a.get((int) i)+" ");
	       
	}
}
