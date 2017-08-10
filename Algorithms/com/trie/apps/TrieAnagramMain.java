package com.trie.apps;

public class TrieAnagramMain {

	public static void main(String[] args) {
	
		TrieAnagramsCyclicwords tac = new TrieAnagramsCyclicwords();
		
	//	String[] pats = {"picture", "turepic", "icturep", "word", "ordw"};
	//	String[] pats = {"ast", "ats", "tas", "tsa", "sat", "sta", "ttt"};
		String[] pats = {"aaaa", "aaa", "aa", "aaaa", "aaaaa"};
				
		tac.buildAnagramTrie(pats);
		tac.vizualize();
		
	}

}
