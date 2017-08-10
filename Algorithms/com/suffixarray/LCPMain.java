package com.suffixarray;

import java.util.Scanner;

public class LCPMain {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		SuffixArray sa = new SuffixArray();
		LCP lcp = new LCP();
		
		String s = scan.next();
		int[] sArray = sa.buildSuffixArray(s);
		System.out.print("\nSuffix Array : ");
		printArray(sArray);
		
		int[] lcpArray  = lcp.computeLCPArray(s, sArray);
		System.out.print("\nLCP Array : ");
		printArray(lcpArray);
		
	}
	
	static void printArray(int[] arr) {
		
		for(int i = 0; i < arr.length; i++)
			System.out.print(" "+arr[i]);
		
		System.out.println();
	}

}
