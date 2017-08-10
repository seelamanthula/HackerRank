package com.strings.trie.hash;

import java.util.ArrayList;

/*
 * Here the space complexity is : O(|sum of all patterns sizes})
 * 
 * Memory is too bad, since it stores 1 character for each node
 */

public class TrieHashConstruction {

	int SMALL_ASCII = 97;
	int BIG_ASCII = 65;	
		
	public TrieHash trieConstruction(String[] patterns) {

		TrieHash root = new TrieHash();
		
		for(int i = 0; i < patterns.length; i++) {
			
			TrieHash access = root;
			char[] s = patterns[i].toCharArray();
			
			for(int j = 0; j < s.length; j++) {
				if(access.hasElement(s[j])) {
					access = access.nextElements.get(s[j]);
				} else {
					access.isLeaf = false;
					TrieHash trie = new TrieHash();
					trie.element = s[j];
					trie.head = access;
					
					access.nextElements.put(s[j], trie);
					access = trie;
				}
			}	
		}
		
		return root;
		
	}
	
	/*
	 * Exact Pattern matching - No Substrings in pattern
	 */
	public ArrayList<String> trieMatching(TrieHash root, String text ) {
		
		TrieHash access = root;
		int i = 0, m = 0;
		char[] chs = text.toCharArray();
		
		ArrayList<String> pat = new ArrayList<String>();
		
		System.out.println("CHS Len : "+chs.length);
		
		while(i < chs.length) {
			
			if(access.isLeaf) {
				pat.add(text.substring(i, i + m));
				access = root;
				i++; m = 0;
				
			} else if(access.hasElement(chs[i + m])) {
				System.out.print(chs[i + m]+" ");
				access = access.nextElements.get(chs[i + m]);
				m++;
			} else {
				i++; m = 0;
				access = root;
			}
		}
		
		return pat;
	}
	
}
