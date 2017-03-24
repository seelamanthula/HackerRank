package strings;

import java.util.Scanner;

public class PalindromeIndex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		while(t > 0) {
			String s = sc.next();
			int n = s.length();
			int pos = 0;
			boolean flag = true;
			
			for(int i = 0; i < n/2 && flag; i++) {
				if(s.charAt(i) != s.charAt(n-i-1)) {
					if(checkPalindrome(s.substring(i + 1, n-i)))
						pos = i;
					else
						pos = n - i -1;
					flag = false;
				}
			}
			
			if(!flag)
				System.out.println(pos);
			else
				System.out.println("-1");
		
			--t;
		}
	}

	public static boolean checkPalindrome(String s) {
		int n = s.length();
		for(int i = 0; i < n/2; i++) {
			if(s.charAt(i) != s.charAt(n-i-1)) {
				return false;
			}
		}
		
		return true;
	}
}
