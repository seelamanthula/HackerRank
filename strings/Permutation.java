package strings;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Permutation {

	static HashSet<String> set = new HashSet<String>();

	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		String s = scan.next();
		int differentLength = 5;
		
		permute("", s, set, differentLength);
		
		Iterator iterate = set.iterator();
		int i  = 1;
		while(iterate.hasNext()) {
			System.out.println(i++ +"  "+iterate.next());
		}
	}
	
	public static void permute(String a, String b, HashSet set, int k) {
	//	if(b.isEmpty()) {
		if(k == 0) {
//			set.add(a + b);
			set.add(a);
		} else {
			for(int i = 0; i < b.length(); i++) {
				permute(a + b.charAt(i), 
						b.substring(0, i) + b.substring(i + 1,b.length()), 
						set, 
						k - 1);
			}
		}
	}
}
