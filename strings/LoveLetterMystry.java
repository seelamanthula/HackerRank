package strings;

import java.util.Scanner;

public class LoveLetterMystry {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t > 0) {
			String s = sc.next();
			int n = s.length();
			
			int count = 0;
			for(int i = 0; i < n/2; i++) {
				char c1 = s.charAt(i);
				char c2 = s.charAt(n-i-1);
				if(c1 != c2) {
					if(c1 > c2)
						count += c1 - c2;
					else
						count += c2 - c1;
				}
			}
			
			System.out.println(count);
			
			--t;
		}
	}

}
