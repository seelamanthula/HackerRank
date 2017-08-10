package com.trie;

import java.util.Scanner;

public class TMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n = 2;
		Scanner scan = new Scanner(System.in);
		String[] pats = {"baby", "box", "dance", "bad", "dad"};

		/*System.out.println("Enter Patterns : ");
		for(int i = 0; i < n ; i++)
			pats[i] = scan.next();*/

		System.out.println("Enter Text : ");
		String text = scan.next();
		
		TriematchConstrut construct = new TriematchConstrut();
		construct.buildTrie(pats);
		construct.searchText(text);
		
		System.out.println("prefix words : "+construct.prefixWords("daddy"));
	}

}
