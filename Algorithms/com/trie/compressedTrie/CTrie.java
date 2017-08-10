package com.trie.compressedTrie;

/*
 * Its a compressed node contains a PREFIX text as a node. 
 */
public class CTrie {

	public CTrie[] child = new CTrie[26];
	public String[] edges = new String[26];
	public boolean isLeaf = true;
	public boolean pattern = true;
	public String visible = "white";
	public String prefix = null;
	
	public CTrie(String prefix) {
		this.prefix = prefix;
	}
	
}
