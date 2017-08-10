package com.suffixarray;

import java.util.Scanner;

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
		
		int low = 0, high = sa.length - 1, mid, i, len = sa.length;
		
		String sub = "";
		while(true) {
			
			mid = (low + high) / 2;
			i = sa[mid];
//			int cmp = text.substring(i, len).compareToIgnoreCase(pat);
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
