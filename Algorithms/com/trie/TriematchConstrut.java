package com.trie;

/*
 * 	Runtime : O(|patterns| + |Text|)
 * 	Memory : O(|Patterns|)
 * 	
 * 	Memory is too bad for regular tries because it stores 1 Node per 1 character
 * 
 */
public class TriematchConstrut {

	Trie1 root = new Trie1();
	
	public void buildTrie(String[] pats) {
		
		Trie1 t = null;
		int k =0;
		for(int i = 0; i < pats.length; i++) {
			
			char[] s = pats[i].toCharArray();
			t = root;
			for(int j = 0; j < s.length; j++) {
				
				k = s[j];
				if(k <= 91)
					k = k - 65;
				else 
					k = k - 97;
				
				if(t.isLeaf)
					t.isLeaf = false;
						
				if(t.child[k] == null) {
					Trie1 tri = new Trie1();
					t.child[k] = tri;
				}
				
				t = t.child[k];
				t.prefixes += 1;
			}
		}
		
	}
	
	public void searchText(String text) {
		
		Trie1 t = root;
		int k = 0, j =0, i = 0;
		char[] s = text.toCharArray();
		while(i+j < text.length() && !t.isLeaf) {
			
			k = s[i+j];
			if(k <= 91)
				k = k - 65;
			else 
				k = k - 97;
			
			if(t.child[k] != null) {
				t = t.child[k];
				j++;
				if(t.isLeaf) {

					System.out.println(i);
					t = root;
					i = i + 1;
					j = 0;
				}
			}	else {
				t = root;
				i = i + 1;
				j = 0;
			}
		}
	}
	
	public int prefixWords(String prefix) {
		int k = 0;
		Trie1 t = root;
		
		char[] s = prefix.toCharArray();
		
		for(int i = 0; i < prefix.length(); i++) {
			
			k = s[i];
			if(k <= 91)
				k = k - 65;
			else 
				k = k - 97;
			
			
			if(t.child[k] == null)
				return 0;
			else 
				t = t.child[k];
		}
		
		return t.prefixes;
	}
	
	
}
