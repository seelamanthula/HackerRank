package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Candies2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();	
		//n  = 1000;
		long[] a = new long[n];
		
		for(int i = 0; i < n; i++)
			a[i] = scan.nextInt();
		
		int[] b = new int[n];
		
		Arrays.sort(a);	
		b[0] = 1;
		
		for(int i  = 1; i < n; i++) {
			if(a[i] == a[i - 1]) {
				b[i] = 1;
			} else if(a[i] > a[i - 1]) {
				b[i] = b[i-1] + 1;
			}
		}

		long count = 0;
		for(int i = 0; i < n; i++) {			
			count += b[i];
			System.out.println((i+1)+" "+a[i]+" "+b[i]);
		}
		
		System.out.println(count);
	}

}
