package com.trie.compressedTrie;

import java.util.Scanner;
import java.util.Stack;

import com.trie.TriematchConstrut;

public class CMain {

	public static void main(String[] args) {

		int n = 2;
		Scanner scan = new Scanner(System.in);
		String[] pats = {"baby", "box", "dance", "bad", "dear", "ear", "dancer", "bank", "boxes", "dad"};
	//	String[] pats = {"bacy", "box", "bad"};
		
	//	String[] pats = {"baby", "bab"}; // case 2
	//	String[] pats = {"box", "boxes"}; // Case 1
	//	String[] pats = {"baby", "baby"}; // case 3
	//	String[] pats = {"baby", "bank"}; // case 4
		
		/*System.out.println("Enter Patterns : ");
		for(int i = 0; i < n ; i++)
			pats[i] = scan.next();*/


		System.out.println("Enter Text : ");
		String text = scan.next();
		
		CTrieConstructMatch construct = new CTrieConstructMatch();
	//	construct.buildCompressTrie(pats);
		construct.buildCTrie(pats);
		construct.searchText(text);
		
		//System.out.println("prefix words : "+construct.prefixWords("daddy"));

//		vizualize(construct.root);
	}

	
	
	
}
