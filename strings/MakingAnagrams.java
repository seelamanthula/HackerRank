package strings;

import java.util.Scanner;

/*
 * Time Complexity : O(s1.len + s2.len)
 * Space Complexity: O(1)
 */

public class MakingAnagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		String s1 = sc.next();
		String s2 = sc.next();
		
		int[] b = countCharacters(s1);
		int count = findDeletions(b, s2);
		
		System.out.println(count);
		
	}

	/*
	 * Time Complexity : O(s2.len + 26) = O(s2.len)
	 */
	public static int findDeletions(int[] b, String s) {
		
		int count = 0;		
		int m = s.length();		
		for(int i = 0; i < m; i++) {
			int c = s.charAt(i) - 97;
			if(b[c] > 0)
				b[c] -= 1;
			else
				++ count;
		}
		
		for(int i = 0; i < 26; i++)
			count += b[i];
		
		return count;
	}
	
	/*
	 * Time Complexity : O(s1.len)
	 */
	public static int[] countCharacters(String s) {
		
		int[] b = new int[26];
		int n = s.length();
		for(int i = 0; i < n; i++) {
			int c = s.charAt(i) - 97;
			b[c] += 1;
		}
		
		return b;
	}
}
