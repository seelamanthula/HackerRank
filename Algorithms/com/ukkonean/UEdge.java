package com.ukkonean;

public class UEdge {

	int start = 0;
	int end = 0;
	int len = 0;
	String color = "white";
	
	public UEdge(int start, int len) {
		this.start = start;
		this.len = len;
		this.end = start + len;
	}
}
