package com.ukkonean;

public class UTrie {

	final int SYMBOLS = 27;
	UTrie[] child = new UTrie[SYMBOLS];
	UEdge[] edges = new UEdge[SYMBOLS];	
	boolean isLeaf = true;
	UTrie sLink = null;
	String color = "white";
	int nodeNumber = 0;
	
	public UTrie(boolean isLeaf, int node) {
		this.isLeaf = isLeaf;
		this.nodeNumber = node;
	}

	public UTrie(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}
}
