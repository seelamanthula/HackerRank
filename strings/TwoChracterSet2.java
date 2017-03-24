package strings;

import java.util.HashSet;
import java.util.Scanner;

public class TwoChracterSet2 {

	/*
	 * Time Complexity is: 26 * 26 * n * k = n * k
	 * Space Complexity is: O(1) - using an array of size 26 and hashset max 26
	 *  
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		
		int[] bCount = new int[26];
		HashSet<Character> set = new HashSet<Character>();

		for(int i = 0; i < s.length(); i++) {
			bCount[s.charAt(i) - 97] += 1;
			set.add(s.charAt(i));
		}

		int  max = 0;
		for(int i  = 0; i < 26; i++) {
			
			if(bCount[i] != 0) {
				set.remove((char) (i+97));
				for(int j = 0; j < 26; j++) {
					if(set.contains((char)(j+97))) {
						set.remove((char) (j+97));
						if(removeFromString(set, s, (char)(i+97), (char)(j+97))) {
							int k = bCount[i] + bCount[j];
							if(k > max)
								max = k;
						}						
						set.add((char) (j+97));
					}
				}
				set.add((char) (i+97));
			}
		}
		
		System.out.println("MAX : "+max);
	}
	
	public static boolean removeFromString(HashSet set, String s, char x, char y) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < s.length(); i++) {
			if(!set.contains(s.charAt(i))) {
				sb.append(s.charAt(i));
			}
		}
		if(check(sb, x, y)) {
			// It is found
			return true;
		}
		return false;
	}
	
	public static boolean check(StringBuilder sb, char x, char y) {
		int k = sb.length();
		
		for(int i = 0, count = 0; i < k-1; i++) {
			if(sb.charAt(i) == x && sb.charAt(i + 1) == y)
				++count;
			else if(sb.charAt(i) == y && sb.charAt(i + 1) == x)
				--count;
			else return false;
			
		}
		
		return true;
	}

}
