package strings;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class SimilarStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int q = sc.nextInt();
		
		StringBuilder A = new StringBuilder(sc.next());
		
		while(q > 0) {
			
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			StringBuilder pat = new StringBuilder(A.subSequence(x - 1, y));
			HashSet<String> main = findPattern2(pat);
			
			int diff = y-x;
			int count = 0, k;
			
			StringBuilder sam = new StringBuilder(A.subSequence(0, diff+1));
			HashSet<String> hs2 = findPattern2(sam);
			if(hs2.size() == main.size()) {
				if(checkHashSets(main, hs2)) {
					++count;
				}
			}
			for(int i = diff+1; i < n; i++) {
				StringBuilder bu = sam.deleteCharAt(0).insert(diff, A.charAt(i));
				HashSet<String> hs = findPattern2(bu);
				if(hs.size() == main.size()) {
					if(checkHashSets(main, hs)) {
						++count;
					}
				}
			}
			
			System.out.println(count);
			--q;
		}
	} 

	// diff = y - ( x - 1 )

	public static boolean checkHashSets(HashSet<String> main, HashSet<String> hMain) {
		
		HashSet<String> hs = hMain;
		
		Iterator<String> iterate = hs.iterator();
		while(iterate.hasNext()) {
			String k = iterate.next();
			if(main.contains(k)) 
				iterate.remove();
			else 
				return false;
		}

		return hs.size() == 0;
	}
	
	public static void iterateHashSet(HashSet main) {
		Iterator iterate = main.iterator();
		while(iterate.hasNext()) {
			System.out.println(iterate.next());
		}
	}
	
	
	public HashSet<String> findPattern(CharSequence pat) {
		
		HashSet<String> hs = new HashSet<String>();
		
		for(int i = 97; i < 123; i++) {
			StringBuilder sb = new StringBuilder();
			for(int j = 0; j < pat.length(); j++) {
				if(pat.charAt(j) == (char)i)
					sb.append(j+"");
			}	
			
			if(sb.length()!=0) {
				hs.add(sb.toString());
			}
		}
		
		return hs;
	}
	
	
	
	public static HashSet<String> findPattern2(CharSequence bu) {
		
		StringBuilder pat = new StringBuilder(bu);
		HashSet<String> hs = new HashSet<String>();
//		for(int i = 97; i < 123; i++) {
		int k = pat.length();
		for(int i = 0; i < k; i++) {
			char c = pat.charAt(i);
			if(c != ' ') {
				StringBuilder sb = new StringBuilder();
				sb.append(i+"");
				pat.replace(i, i+1, " ");
				for(int j = i+1; j < k; j++) {
					if(pat.charAt(j) == c) {
						sb.append(j+"");
						pat.replace(j, j+1, " ");
					}
				}	
				
				if(sb.length()!=0) {
					hs.add(sb.toString());
				}
			}
		}
		
		return hs;
	}
}
