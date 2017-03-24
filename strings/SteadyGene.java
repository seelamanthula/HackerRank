package strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class SteadyGene {

	public static HashSet set = new HashSet();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String s = sc.next();
		
		int[] b = new int[20];
		//int n = s.length();
		for(int i = 0; i < n; i++) {
			char c = s.charAt(i);
			b[(int) c - 65] += 1;
		}
		int avg = n/4;
		
		int[] e = new int[20];
		int count = 0;
		int i = 0;
		try {
			for(i = 0; i < 20; i++) {
				if(b[i] > avg) {
					e[i] = b[i] - avg;
					count += e[i];
				}
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			System.out.println("I : "+i);
		}
		StringBuilder sb = new StringBuilder();
		HashSet[] arr = new HashSet[n - count];
		
		for(int j = count; j < n; j++) {
			permute("", s, set, j);
		}

		iterate(set);
		//findSubString(s, e);
	}
	
	public static void findSubString(String s, int[] cou) {
		
		Iterator iterate = set.iterator();
		int mini = s.length();
		StringBuilder sb = new StringBuilder();
		while(iterate.hasNext()) {

			int[] e = cou;
			
			StringBuilder pat = new StringBuilder((String) iterate.next());
			if(s.contains(pat)) {
				
				if(mini > pat.length()) {
//					System.out.println("Less Length");
					
					if(satisfy(pat, e)){
						//System.out.println("satisfied");
	//					System.out.println("Came In "+pat);
						mini = pat.length();
						sb = pat;
					}
				}
			}
		}
		
		System.out.println("Found : "+sb);
		System.out.println("Len : " +sb.length());
	}
	
	public static boolean satisfy(StringBuilder pat, int[] cou) {
		
		int[] e = new int[20];

		int n = pat.length();
		for(int i = 0; i < n; i++) {
			char ch = pat.charAt(i);
			e[(char) ch - 65] += 1;
		}


		for(int i = 0; i < 20; i++) {
			if((cou[i] - e[i]) > 0)
				return false;
		}
		
		return true;
	}
	
	public static void iterate(HashSet set) {
		Iterator iterate = set.iterator();
		int i  = 1;
		while(iterate.hasNext()) {
			System.out.println(i++ +"  "+iterate.next());
		}
	}
	
	public static void permute(String a, String b, HashSet hs, int k) {
	//	if(b.isEmpty()) {
		if(k == 0) {
//			set.add(a + b);
			set.add(a);
		} else {
			for(int i = 0; i < b.length(); i++) {
				permute(a + b.charAt(i), 
						b.substring(0, i) + b.substring(i + 1,b.length()), 
						hs,
						k - 1);
			}
		}
//		return hs;
	}
}
