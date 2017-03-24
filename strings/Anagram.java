package strings;

import java.util.Scanner;


/*
 * Time Complexity: s =  O(n/2) = O(n)
 * 
 * Space Complexity = O(1)
 */

public class Anagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);	
		int t = sc.nextInt();
		
		while(t > 0) {

			String s = sc.next();		
			int n = s.length();
			
			if(n%2 == 1)
				System.out.println(-1);
			else {
				
				StringBuilder sb1 = new StringBuilder(s.substring(0, n/2));
				StringBuilder sb2 = new StringBuilder(s.substring(n/2, n));
				
				int[] b = characterCount(sb2);
				int count = checkAnagram(sb1, b);
				
				System.out.println(count);
			}
		
		--t;
		}
	}
	
	/*
	 * Time Complexity: s = n/2
	 * 
	 * 			O(s + 26) = O(n/2) = O(n)
	 */
	
	public static int checkAnagram(StringBuilder s, int[] b) {
		
		for(int i = 0; i < s.length(); i++) {
			int c = s.charAt(i) - 97;
			if(b[c] > 0) {
				b[c] -= 1;
			}
		}
		
		int count = 0;
		for(int i = 0; i < 26; i++) 
			if(b[i] > 0)
				count += b[i];
		
		return count;
	}
	
	/*
	 * Time Complexity: O(26) = O(1)
	 */
	
	public static int[] characterCount(StringBuilder s) {
		int[] b = new int[26];
		
		for(int i = 0; i < s.length(); i++) {
			int c = s.charAt(i) - 97;
			b[c] += 1;
		}
		
		return b;
	}
}
