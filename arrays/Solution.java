package arrays;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		
		int[] a = new int[n];
		for(int i = 0; i<n; i++)
			a[i] = scan.nextInt();
		
		for(int i = n - 1; i >= 0; i--)
			System.out.println(a[i] + " ");
		
	}

}
