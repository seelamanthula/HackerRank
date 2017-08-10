package com.suffixarray;

import java.util.Scanner;

public class STreeMain {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String text = scan.next();
		
		SuffixArray array = new SuffixArray();
		int[] sa = array.buildSuffixArray(text);
		
		LCP lcp = new LCP();
		int[] lcpA = lcp.computeLCPArray(text, sa);
		
		System.out.println("Suffix Array : ");
		lcp.prineArray(sa);
		
		System.out.println("LCP Array : ");
		lcp.prineArray(lcpA);
		
		SuffixTree tree = new SuffixTree();
		tree.buildSuffixTree(sa, lcpA, text);

		System.out.println("\n\nFinal Nodes");
		tree.visualize(text);
		
	}

}
