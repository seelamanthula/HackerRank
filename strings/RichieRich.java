package strings;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RichieRich {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		
		int n, k;
		String s;
		n = scan.nextInt();
		k =  scan.nextInt();
		s = scan.next();
		
		System.out.println(n + " "+ k);
		System.out.println(s);
		
		boolean[] change = new boolean[n];
		for(int i = 0; i < n; i++)
			change[i] = false;
		
		char[] sChars = s.toCharArray();
		
//		int j = sChars.length;
		
		for(int i = 0; i < n/2; i++) {
			if(sChars[i] != sChars[n - i - 1]) {
				
				if((int)sChars[i] > (int)sChars[n - i - 1]) {					
					sChars[n - i - 1] = sChars[i];
					change[n - i - 1] = true;
				} else {
					sChars[i] = sChars[n - i - 1];
					change[i] = true;
				}
				
				k--;
			}
		}
		
		for(int i = 0; i < n/2 && k > 0; i++) {
			if(sChars[i] != '9' || sChars[n-i-1] != '9') {
				if(change[i] || change[n-i-1]) {
					if(k > 0) {
						sChars[i] = '9';
						sChars[n-i-1] = '9';
						k--;
					}					
				} else {
					if(k >= 2) {
						sChars[i] = '9';
						sChars[n-i-1] = '9';	
						k -= 2;
					}
				}
			}
		}
		
		if(n%2 ==1 && k > 0) {
			sChars[(n+1)/2 - 1] = '9';
		}
		
		String s2 = sChars.toString();
		
		if(k < 0) {
			System.out.println("-1");
		}
		else {
			System.out.println(sChars);
		}
		
	}

}
