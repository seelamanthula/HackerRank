package com.strings.trie.hash;

import java.util.List;

import com.strings.trie.Trie;
import com.strings.trie.TrieConstruction;

public class TrieHashMain {

	public static void main(String[] args) {

		TrieHashConstruction trie = new TrieHashConstruction();
		
		String text = "panamabananas";
		String[] patterns = {"banana", "pan", "and", "nab", "antenna", "bandana", "ananas", "nana"};
		TrieHash root = trie.trieConstruction(patterns);
//		root.containElements();
		List<String> list = trie.trieMatching(root, text);
		
		System.out.println("List : "+list);
	}
}
