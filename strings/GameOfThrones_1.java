package strings;

import java.util.Scanner;

public class GameOfThrones_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		
		int[] b = countCharacters(s);
		if(checkPalindrome(b)) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}

	public static boolean checkPalindrome(int[] b) {
		
		boolean flag = false;
		
		for(int i = 0; i < 26; i++) {
			if(b[i]%2 == 1) {
				if(flag)
					return false;
				
				flag = true;
			}
		}
		
		return true;
	}
	
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
