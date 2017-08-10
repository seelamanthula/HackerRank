package com.suffixarray;

/*
 * SuffixTree Node works with all english alphabets.
 * 		
 */

public class SANode {

	final int SYMBOLS = 27;
	
	int length = 0;
	int start = 0;
	int pLength = 0;
	
	boolean isLeaf = true;
	SANode parent = null;
	int suffixPosition = 0;
	
	SANode[] child = new SANode[SYMBOLS];
	
	String visible = "white";
}
