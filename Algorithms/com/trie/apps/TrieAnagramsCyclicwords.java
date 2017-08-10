package com.trie.apps;

import java.util.ArrayList;
import java.util.Iterator;

import com.sort.CountingSort;
import com.trie.compressedTrie.CTrie;
import com.trie.compressedTrie.CTrieConstructMatch;

/*
 * 		Input Cyclic words find the number of anagramic words in the given set of words.
 * 
 * 		Runtime : O(|patterns| + k) where k is a constant for counting sort
 * 		
 * 		Since it is a compressed trie it useses very less memory.
  */
public class TrieAnagramsCyclicwords {

	CTrie root = new CTrie("");
	
	void buildAnagramTrie(String[] pats) {
	
		int i = 0, j = 0, SMALL = 97, ch, k = 0;
		CTrie t = null;
		String e;
		
		CountingSort sort = new CountingSort();
		
		for(i = 0; i < pats.length; i++) {
			
			String s = pats[i];
			String en = sort.performSort(s);
			j = 0;
			t = root;
			
			while(j < en.length()) {
				
				ch = en.charAt(j) - SMALL;
				
				if(t.child[ch] == null) {
					t.isLeaf = false;
					t.edges[ch] = en.substring(j, en.length());
					t.child[ch] = new CTrie(en);
					j =  en.length();
				} else {
					
					e = t.edges[ch];
					k = 0;
					while(k < e.length() && j < en.length()) {
						if(en.charAt(j) == e.charAt(k))  {
							j++; k++;
						} else break;
					}
					
					if(k == e.length()) { 
						
						t = t.child[ch];     
						
						if(j == en.length()) {  // Case - 1: |e| = |en|
							t.pattern = true;   // Ex: e = Baby, en = Baby
						} else  {			    // Case - 2: |e| subset |en|
							t.isLeaf = false;   // Ex: e = Baby, en = Babys  
						}				
					} else if(k < e.length()){   // |en| subset or equal |e|
						
						CTrie temp = t.child[ch];
						CTrie nc = new CTrie(temp.prefix.substring(0, j));
						
						t.edges[ch] = e.substring(0, k);
						t.child[ch] = nc;
						t.isLeaf = false;
						t.pattern = false;
						
						int rh =  e.charAt(k)- SMALL;
						nc.edges[rh] = e.substring(k, e.length());
						nc.child[rh] = temp;
						nc.pattern = false;
						nc.isLeaf = false;
						
						if(j ==  en.length()) { // case - 3: |en| subset to |e|
							nc.pattern = true;	// Ex: e = Baby, en = Bab
						} else		{			// case - 4: |en| partially subset to |en| 
							t = t.child[ch];	// Ex: e = Baby, en = Bank
						}
					}
				}
			}			
		}
		
	}

	
	public void vizualize() {
		
		CTrieConstructMatch match = new CTrieConstructMatch();
		ArrayList<String> list = match.vizualize(root);
		
		System.out.println("Different Elements : "+list.size());
	}
}
