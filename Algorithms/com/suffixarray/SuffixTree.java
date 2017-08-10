package com.suffixarray;

import java.util.Stack;

/*
 * 		Input needed: Suffix Array, Text and LCP Array		
 * 
 * 		Run time : O(|Text|)
 * 		Memory : O(2 * |Text|)
 * 
 */

public class SuffixTree {

	SANode root = null;
	
	private int getPosition(char ch) {
		if(ch == '$') return 0;
		else if(ch < 91) return ch - 64;
		else return ch - 96;
	}
	
	public void buildSuffixTree(int[] suffixArray, int[] lcpArray, String text) {
		
		int ch, alcp, ast, st, lcp, i, n = suffixArray.length;
		root = new SANode();
		SANode t = root;
		
		for(i = 0; i < n; i++) {
			
			ast = suffixArray[i];
			
			if(i == n - 1) { // If the lcp array ends
				lcp = 0; alcp = 0;
				st = ast + lcpArray[n - 2];
			} else {
				alcp = lcpArray[i];
				lcp = alcp - t.pLength;
				st = ast + t.pLength;
			}
			
			ch = getPosition(text.charAt(st));
			
			System.out.println("\n\nI : "+i+", lcp : "+lcp+", ast : "+ast+", st : "+st+", ch : "+ch);
			
			if(lcp < 0) lcp = 0;
			
			if(lcp > 0) {
			
				// Creating intermediate nodes
				
				t.isLeaf = false;
				SANode sat = new SANode();
				t.child[ch] =  sat;
				
				sat.start = st;
				sat.isLeaf = false;
				sat.length = lcp;
				sat.pLength = lcp + t.pLength;
				sat.parent = t;
				
				st = ast + alcp;
				t = t.child[ch];
				
				ch = getPosition(text.charAt(st));
			}
	
			// Making the current node as a parent node by adding a child node to it.
			
			t.isLeaf = false;
			SANode sat = new SANode();
			t.child[ch] = sat;
			
			sat.isLeaf = true;
			sat.start = st;
			sat.length = n - st;
			sat.pLength = n - ast;
			sat.parent = t;
			sat.suffixPosition = ast;
	//		t = sat;
			
			if(alcp == 0) {
				t = root;
				System.out.println("To Root");
			}
			else {
		//		t = t.parent;
				System.out.println("To Parent");
			}
			
			visualize(text);
			changeColor(root);
		}
		
	}
	
	public void changeColor(SANode trie) {

		SANode root = trie;
		Stack<SANode> stack = new Stack<SANode>();
		stack.push(root);
		while(!stack.isEmpty()) {
			
			SANode t = stack.peek();
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
	
	public void visualize(String text) {
		
		Stack<SANode> stack = new Stack<SANode>();
		stack.push(root);
		
		SANode t = null;
		int wCount = 0;

		while(!stack.isEmpty()) {
			
			t = stack.peek();
			for(int i = 0; i < 26 && !t.isLeaf ; i++) {
				if(t.child[i] != null && t.child[i].visible == "white") {
				
					t.child[i].visible = "grey";
					stack.push(t.child[i]);
					t = stack.peek();
					wCount++;
					i = -1;
	
					System.out.print("\n"+wCount+" "+text.substring(t.start, t.start + t.length));
					if(t.isLeaf) System.out.print(" Suffix : "+t.suffixPosition);	
				}
			}

			t = stack.peek();
			
			t.visible = "black";
			stack.pop();
			wCount--;
		}
				
	}
}
