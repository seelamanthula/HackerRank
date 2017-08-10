package com.strings.trie.hash;

import java.util.HashMap;

import com.strings.trie.Trie;

public class TrieHash {

	char element = '\0'; // Empty Char
	HashMap<Character, TrieHash> nextElements = new HashMap<Character, TrieHash>();
	boolean isLeaf = true;
	TrieHash head = null;
	
	boolean hasElement(char ch) {
		if(isLeaf) return false;
		
		if(nextElements.containsKey(ch)) 
			return true;
		
		return false;
	}	
}
