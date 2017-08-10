package com.trie.compressedTrie;

import java.util.ArrayList;
import java.util.Stack;

/*
 * 	Input : patterns
 * 	Runtime : O(|patterns| + |Text|)
 * 	Memory is saves a lot of memory at each node by combining the single character nodes.
 * 
 */
public class CTrieConstructMatch {

	CTrie root = new CTrie(null);
	
	/*
	 * 	constructs compressed trie with the given set of patterns
	 */
	public void buildCTrie(String[] pats) {
		
		CTrie t = null;
		int i, k, ch, j, SMALL = 97;
		String en, e;
		
		for(i = 0; i < pats.length; i++) {
			
			t = root;
			en = pats[i];
			j = 0;
			
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
							System.out.println("Case - 1");
						} else  {			    // Case - 2: |e| subset |en|
							t.isLeaf = false;   // Ex: e = Baby, en = Babys  
						}				
					} else if(k < e.length()){   // |en| subset or equal |e|
						
						CTrie temp = t.child[ch];
						CTrie nc = new CTrie(temp.prefix.substring(0, j));
						
						t.edges[ch] = e.substring(0, k);
						t.child[ch] = nc;
						t.isLeaf = false;
						t.pattern = t.pattern; // COrner Testcase
						
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
		vizualize(root);
	}
	
	
	public void changeColor(CTrie trie) {

		CTrie root = trie;
		Stack<CTrie> stack = new Stack<CTrie>();
		stack.push(root);
		while(!stack.isEmpty()) {
			
			CTrie t = stack.peek();
			for(int i = 0; i < 26 && !t.isLeaf; i++) {
				if(t.child[i] != null && t.child[i].visible != "white") {
					t.child[i].visible = "white";
					stack.push(t.child[i]);
					t = stack.peek();
					i = 0;
				}
			}
			
			stack.pop();
		}
	}
	
	public ArrayList<String> vizualize(CTrie trie) {
		System.out.println("In vizualize..");
		
		ArrayList<String> list = new ArrayList<String>();
		
 		CTrie root = trie;
		Stack<CTrie> stack = new Stack<CTrie>();
		stack.push(root);
		
		int wCount = 0;
		while(!stack.isEmpty()) {
			
			CTrie t = stack.peek();
			for(int i = 0; i < 26 && !t.isLeaf ; i++) {
				if(t.child[i] != null && t.child[i].visible == "white") {
				
					t.child[i].visible = "grey";
					stack.push(t.child[i]);
					t = stack.peek();
					wCount++;
					i = -1;
	
					if(t.isLeaf || t.pattern) {// Preorder traversal - lexographical sorting of strings {
						System.out.println(wCount+" "+t.prefix);
						list.add(t.prefix);
					}
				}
			}

			t = stack.peek();
			t.visible = "black";
			stack.pop();
			wCount--;
		}
		
		return list;
	}
	
	int check(String st, String text, int i) {

		if(text.substring(i).length() < st.length())
			return -1;
		
		for(int j = 0; j < st.length(); j++)
			if(st.charAt(j) != text.charAt(i+j))
				return -1;
		
		return st.length();
	}
	
	public void searchText(String text) {
		
		System.out.println("\n\n -- SEARCH --");
		CTrie t = root;
		int i = 0, j = 0, k = 0, ch;
		char[] txt = text.toCharArray();
		
		while(i + j < text.length()) {
			
			ch = txt[i+j] - 97;
			
			if(t.child[ch] != null) {
				
				String st = t.edges[ch];
				k = check(st, text, i+j);
				if(k == -1) {
					i++; t = root; j = 0;
				} else {
					t = t.child[ch];
					j = j + k;

					if(t.pattern) {
						System.out.println(" At : "+i+" Length : "+j);
					}
					if(t.isLeaf  || i + j == text.length()) {
						i = i + 1;
						j = 0;
						t = root;
					} 
				}
			} else {
				i++;
				t = root;
				j = 0;
			}
		}
	}


}
