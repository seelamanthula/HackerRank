package com.trie.apps;

public class TagalogMain {

	public static void main(String[] args) {
		
		TagalogDictionary dict = new TagalogDictionary();
		
		// String[] pats = {"abakada","alpabet","tagalog","ako"};
		// String[] pats = {"ang","ano","anim","alak","alam","alab"};
		// String[] pats = {"siya","niya","kaniya","ikaw","ito","iyon"};
		// String[] pats = {"kaba","baka","naba","ngipin","nipin"};
		 String[] pats = {"knilngiggnngginggn","ingkigningg","kingkong","dingdong","dindong","dingdont","ingkblot"};
		// String[] pats = {"silangang", "baka", "bada", "silang"};
		
		dict.buildTagalogDictionary(pats);
		System.out.println("Sorded Order");
		dict.sortedOrder();
		
	}

}
