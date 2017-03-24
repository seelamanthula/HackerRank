package strings;

import java.util.HashSet;
import java.util.Scanner;

public class TwoStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int t =  sc.nextInt();
		
		while(t > 0) {
			String s1 = sc.next();
			String s2 = sc.next();
			
			HashSet hs = new HashSet();
			
			int n = s1.length();
			for(int i = 0; i < n; i++)
				hs.add(s1.charAt(i));
			
			int m = s2.length();
			boolean flag = true;
			for(int i = 0;i < m && flag; i++) {
				char c = s2.charAt(i);
				if(hs.contains(c)) {
					flag = false;
				}
			}
				
			if(!flag) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
			
			--t;
		}
	}

}
