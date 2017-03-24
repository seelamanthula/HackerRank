package strings.palindrome;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class BuildPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String sa, sb;
		Scanner sc = new Scanner(System.in);
		int q = sc.nextInt();
		
		while(q > 0) {
		
		sa = sc.next();
		sb = sc.next();
		
		int max = 0;
		
		HashSet<String> SA = new HashSet<String>();
		HashSet<String> SB = new HashSet<String>();
		
	/*	ArrayList<String> SA = new ArrayList<String>();
		ArrayList<String> SB = new ArrayList<String>();*/
		
		HashMap<Integer, String> res = new HashMap<Integer, String>();
		
		for(int i = 0; i < sa.length(); i++) {
			for(int j = i + 1; j < sa.length() + 1; j++) {
				String a = sa.substring(i, j);
				SA.add(a);
			}
		}
		
		for(int i = 0; i < sb.length(); i++) {
			for(int j = i + 1; j < sb.length() + 1; j++) {
				String a = sb.substring(i, j);
				SB.add(a);
			}
		}
		
		String[] saArr = SA.toArray(new String[SA.size()]);
		String[] sbArr = SB.toArray(new String[SB.size()]);		
	
		/*System.out.println("== A ==");
		printArray(saArr);
		System.out.println("== B ==");
		printArray(sbArr);*/

		
		for(int i = 0; i < saArr.length; i++) {
			
			String s1 = saArr[i];
			
			// Prefix
			for(int j = 0; j < s1.length(); j++) {
				String t = s1.substring(0, j+1);
				String tr = reverse(t);
				
				if(SB.contains(tr)) {
					if(isPalindrome(s1+tr)) {
						int len = (s1+tr).length();
						if(!res.containsKey(len))
							res.put(len, s1+tr);
						if(max < len)
							max = len;
					}
				}
			}
			
		}
		
		for(int i = 0; i < sbArr.length; i++) {
		
			String s1 = sbArr[i];
			int k = s1.length();
			
			// Suffix
			for(int j = k; j > 0; j--) {
				String t = s1.substring(j-1, k);
				String tr = reverse(t);
				
				if(SA.contains(tr)) {
					if(isPalindrome(tr+s1)) {
						int len = (tr+s1).length();
						if(!res.containsKey(len))
							res.put(len, tr+s1);
						if(max < len)
							max = len;
					}
				}
			}
		}
		
		if(max > 0)
			System.out.println(res.get(max));
		else
			System.out.println(-1);
		
	//	printHashMap(res);
		
	//	System.out.println(res.get(4));
		
		q--;
		}
	}

	public static void printHashMap(HashMap map) {
		Iterator it = map.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        System.out.println(pair.getKey() + " = " + pair.getValue());
	       // it.remove(); // avoids a ConcurrentModificationException
	    }
	}
	
	public static void printArray(String[] s) {
		
		int n = s.length;
		
		for(int i = 0; i < n; i++)
			System.out.println(s[i]);
	}
	public static boolean isPalindrome(String s) {
	
		int n = s.length();
		
		for(int i = 0; i < n/2; i++) {
			if(s.charAt(i) != s.charAt(n - 1- i))
				return false;
		}
		
		return true;
	}
	
	public static String reverse(String s) {
		
		StringBuilder sb = new StringBuilder();
		int n = s.length();
		for(int i = n - 1; i >= 0; i--) {
			sb.append(s.charAt(i));
		}
		return sb.toString();
	}
}
