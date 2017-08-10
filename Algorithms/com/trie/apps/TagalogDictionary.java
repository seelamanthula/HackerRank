package com.trie.apps;

import com.trie.compressedTrie.CTrie;
import com.trie.compressedTrie.CTrieConstructMatch;

/*
 * 

Source: https://community.topcoder.com/stat?c=problem_statement&pm=7411

 Problem Statement for TagalogDictionary


Problem Statement
    	
In the first half of the 20th century, around the time that Tagalog became the national language of the Philippines, a standardized alphabet was introduced to be used in Tagalog school books (since then, the national language has changed to a hybrid "Pilipino" language, as Tagalog is only one of several major languages spoken in the Philippines).

Tagalog's 20-letter alphabet is as follows:

a b k d e g h i l m n ng o p r s t u w y
Note that not all letters used in English are present, 'k' is the third letter, and 'ng' is a single letter that comes between 'n' and 'o'.

You are compiling a Tagalog dictionary, and for people to be able to find words in it, the words need to be sorted in alphabetical order with reference to the Tagalog alphabet. Given a list of Tagalog words as a String[], return the same list in Tagalog alphabetical order.

 
Definition
    	
Class:	TagalogDictionary
Method:	sortWords
Parameters:	String[]
Returns:	String[]
Method signature:	String[] sortWords(String[] words)
(be sure your method is public)
    
 
Notes
-	Any 'n' followed followed by a 'g' should be considered a single 'ng' letter (the one that comes between 'n' and 'o').
 
Constraints
-	words will contain between 1 and 50 elements, inclusive.
-	Each element of words will contain between 1 and 50 characters, inclusive.
-	Each character of each element of words will be a valid lowercase letter that appears in the Tagalog alphabet.
-	Each element of words will be distinct.
 
Examples
0)	
    	
{"abakada","alpabet","tagalog","ako"}
Returns: {"abakada", "ako", "alpabet", "tagalog" }
The tagalog word for "alphabet", a Tagalogization of the English word "alphabet", the name of the language, and the word for "I".
1)	
    	
{"ang","ano","anim","alak","alam","alab"}
Returns: {"alab", "alak", "alam", "anim", "ano", "ang" }
A few "A" words that are alphabetically close together.
2)	
    	
{"siya","niya","kaniya","ikaw","ito","iyon"}
Returns: {"kaniya", "ikaw", "ito", "iyon", "niya", "siya" }
Common Tagalog pronouns.
3)	
    	
{"kaba","baka","naba","ngipin","nipin"}
Returns: {"baka", "kaba", "naba", "nipin", "ngipin" }
4)	
    	
{"knilngiggnngginggn","ingkigningg","kingkong","dingdong","dindong","dingdont","ingkblot"}
Returns: 
{"kingkong",
"knilngiggnngginggn",
"dindong",
"dingdont",
"dingdong",
"ingkblot",
"ingkigningg" }
5)	
    	
{"silangang", "baka", "bada", "silang"}
Returns: {"baka", "bada", "silang", "silangang" }

 * 
 */
public class TagalogDictionary {

	CTrie root = new CTrie("");
	
	
	/*
	 * Time Complexity : O(|pats|) -  O(|sum of all characters in patterns|)
	 */
	public void buildTagalogDictionary(String[] pats) {
		
		int i, ch, k, j, enlen;
		StringBuilder al = null;
		CTrie t = null;
		String e = null;
		
		for(i = 0; i < pats.length; i++) {
			
			String en = pats[i];
			enlen = en.length();
			j = 0;
			t = root;

			while(j < enlen) {

				al = new StringBuilder(en.charAt(j)+"");

				if(en.charAt(j) == 'n' && j+1 < enlen) {
					if(en.charAt(j+1) == 'g') 
						al = new StringBuilder("ng");
				}
				
				ch = getPosition(al);
				
				if(t.child[ch] == null) {
					t.isLeaf = false;
					t.edges[ch] = en.substring(j);
					t.child[ch] = new CTrie(en);
					j = enlen;
				} else {
					
					e = t.edges[ch];
					k = 0;
					while(j < enlen && k < e.length()) {
						
						if(en.charAt(j) == e.charAt(k)) {
							j++; k++;
						} else if((j > 0 && en.charAt(j - 1) == 'n' && en.charAt(j) == 'g') ||
								 (k > 0 && e.charAt(k - 1) == 'n' && e.charAt(k) == 'g')) { k--; j--; break; }
						else break;
					}
					
					if(k == e.length()) {
						
						t = t.child[ch];
						if(j == enlen) 
							t.pattern = true;
						else
							t.isLeaf = false;
						
					} else if(k < e.length()) {
						
						CTrie temp = t.child[ch];
						CTrie nc = new CTrie(temp.prefix.substring(0,j));
						t.edges[ch] = e.substring(0,k);
						t.child[ch] = nc;
						t.isLeaf = false;
						t.pattern = false;
						
						al = new StringBuilder(e.charAt(k)+"");
						if(e.charAt(k) == 'n' && k+1 < e.length()) {
							if(e.charAt(k+1) == 'g') al = new StringBuilder("ng");
						}
						
						int rh = getPosition(al);
						
						nc.edges[rh] = e.substring(k);
						nc.child[rh] = temp;
						nc.isLeaf = false;
						nc.pattern = false;
						
						if(j == enlen)
							nc.pattern = true;
						else 
							t = t.child[ch];
					}
				}
			}
		}
	}
	
	public void sortedOrder() {
		CTrieConstructMatch match = new CTrieConstructMatch();
		match.vizualize(root);
		match.changeColor(root);
	}
	
	private int getPosition(StringBuilder sb) {
		
		if(sb.length() > 1) return 11; 
		
		char ch = sb.charAt(0);
		switch(ch) {
		
			case 'a': return 0;
			case 'b': return 1;
			case 'k': return 2;			
			case 'd': return 3;
			case 'e': return 4;
			case 'g': return 5;			
			case 'h': return 6;
			case 'i': return 7;
			case 'l': return 8;			
			case 'm': return 9;
			case 'n': return 10;
			case 'o': return 12;			
			case 'p': return 13;
			case 'r': return 14;
			case 's': return 15;			
			case 't': return 16;
			case 'u': return 17;
			case 'w': return 18;			
			case 'y': return 19;			
			default: return -1;
		}
		
	}
	
}
