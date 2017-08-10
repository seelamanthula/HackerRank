package com.ukkonean;

import java.util.Scanner;

public class SUMain {

	public static void main(String[] args) {

		System.out.println("Enter Text : ");
		Scanner scan = new Scanner(System.in);
		String s = scan.next();
		
		SUkkonean su = new SUkkonean(s);
		su.buildSuffixTrie();
		su.printTree();
		
	}

}
