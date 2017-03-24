package arrays;

import java.util.Scanner;

/*
 * Time Complexity: O(n^2)
*/
public class Candies {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();	
		//n  = 1000;
		long[] a = new long[n];
		
		for(int i = 0; i < n; i++)
			a[i] = scan.nextInt();
		
		int[] b = new int[n];
		b[0] = 1;
		int high = 0;
		
		for(int i = 1; i < n ; i++) {
			
			if(a[i] > a[i - 1]) {
				b[i] = b[i-1] + 1;
				high = i;
			}  else {
				if(i == 1) {
					if(a[0] == a[1]) {
						b[1] = 1;
						high = 1;
					} else {
						b[0] += 1;
						b[i] = 1;
					}
				}
				else {
					if(b[i-1]-b[i-2] < 1) {
						if((a[i] == a[i-1]) && (b[i-1] == 1)) {
							System.out.println("Coming inside");
								b[i] = 1;
								high = i;
						} else {
							if(b[high] - b[high + 1] == 1 || b[high] - b[high + 1] == 0)
								b[high] += 1;
							
							for(int k = high + 1; k < i; k++)
								b[k] += 1;
							
							b[i] = 1;
						}
					} else {
						b[i] = 1;
					}
				}
//				b[i] = 1;
			}
		}
		
		long count = 0;
		for(int i = 0; i < n; i++) {
			System.out.println(i+" "+a[i]+" "+b[i]);
			count += b[i];
		}
		
		System.out.println(count);
	}

}
