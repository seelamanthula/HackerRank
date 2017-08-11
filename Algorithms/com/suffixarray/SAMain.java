package com.suffixarray;

import java.util.Scanner;

/*
 *	If we use binarysearch2() method in this suffix array to find a pattern, it takes O(mlog n) -> O(|pat| log |Text|)
 *		because we are comparing each suffix in the array for log n times.
 *
 *	If we use binarysearch() method in this suffix array to find a pattern, it takes O(m + log n) -> O(|pat| + log |Text|)
 *		because we use comparing the prefix only once (storing the prefix value in kcp).
 *
 */
 
public class SAMain {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		SuffixArray sa = new SuffixArray();

		System.out.println("Enter Text : ");
		String s = scan.next();
		
		int[] sarray = sa.buildSuffixArray(s);
		System.out.print("\nSuffix Array :");
		for(int i = 0; i < sarray.length; i++)
			System.out.print(" "+sarray[i]);
		
		System.out.println("Enter Pattern : ");
		String pat = scan.next();
		binarySearch(sarray, pat, s);
		
	}
	
	static void binarySearch(int[] sa, String pat, String text) {
		
		int lcp = 0, low = 0, high = sa.length - 1, mid, i, len = sa.length, kcp = 0;
		
		String sub = "";
		while(true) {
			
			mid = (low + high) / 2;
			i = sa[mid];
			sub = text.substring(i);
			kcp = compareTo(sub, pat, kcp);	
			
			System.out.println("sub :"+sub +", pat :"+pat+" "+i);
			System.out.println("KCP : "+kcp+" "+low+" "+mid+" "+high);
			
			if(high < low) {
				System.out.println("Pattern could not found");
				break;
			} else if(kcp == pat.length()) {
				System.out.println("Found pattern at : "+sa[mid]);
				break;
			} else if(kcp > sub.length() || sub.charAt(kcp) < pat.charAt(kcp)) { 
				// kcp > sub.length() because length of the suffix in a suffix array reduces 
				// for every particular character 
				// Ex: For String "ababaa$" : $, a$, aa$, abaa$, ababaa$, baa$, babaa$
				low = mid + 1;
			} else if(sub.charAt(kcp) > pat.charAt(kcp)) {				
				high = mid - 1;
			}
		}
		
	}


	static int compareTo(String sub, String pat, int kcp) {
		
		sub = sub.toLowerCase();
		pat = pat.toLowerCase();
		
		while(kcp < pat.length() && kcp < sub.length()) {
			
			if(pat.charAt(kcp) == sub.charAt(kcp)) kcp = kcp + 1;
			else break;
			
		}
		
		return kcp;
	}
	

	static void binarySearch2(int[] sa, String pat, String text) {
		
		int low = 0, high = sa.length - 1, mid, i, len = sa.length;
		
		String sub = "";
		while(true) {
			
			mid = (low + high) / 2;
			i = sa[mid];
			int cmp = compareTo(text.substring(i), pat);
			System.out.println(text.substring(i) +" "+pat+" "+i);
			System.out.println("CMP : "+cmp+" "+low+" "+mid+" "+high);
			if(high < low) {
				System.out.println("Pattern could not found");
				break;
			} else if(cmp == 0) {
				System.out.println("Found pattern at : "+sa[mid]);
				break;
			} else if(cmp > 0) {
				high = mid - 1;
			} else if(cmp < 0) {
				low = mid + 1;
			} 
		}
		
	}

	static int compareTo(String sub, String pat) {
		
		sub = sub.toLowerCase();
		pat = pat.toLowerCase();
		
		if(sub.length() < pat.length())
			return -1;
		
		for(int i = 0; i < pat.length(); i++) {
			if(sub.charAt(i) != pat.charAt(i)) {
				if(sub.charAt(i) > pat.charAt(i))
					return 1; 
				else
					return -1;	
			}
		}
		
		return 0;
	}
}
