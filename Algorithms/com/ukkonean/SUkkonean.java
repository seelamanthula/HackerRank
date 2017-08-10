package com.ukkonean;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;
/*
 * Its a ukkonean algorithm, which works in linesr time.
 * 
 * Problem: revesiting the parent in a substring
 * Ex: ACACAA
 * 
 * Run time: O(|Text|)
 * Memeory: O(2 * |Text|)
 * 
 */
public class SUkkonean {

	UTrie root = new UTrie(false, -1);
	char[] txt;
	int length;
	StringBuilder text = null;
	int SMALL = 97, BIG = 65, nodeNo = 0;
	HashSet<UEdge> set = null;
	
	public SUkkonean(String text) {
		length = text.length();
		txt = text.toCharArray();
		this.text = new StringBuilder(text);
	}

	private int getPosition(char c) {
		if(c == '$') return 0;
		else if(c < 91) return c - BIG + 1;
		else return c - SMALL + 1;
	}
	
	public void buildSuffixTrie() {
		
		UTrie an = root;
		int i = 0, ch = 0, al = 0, remain = 0, split1 = 0, split2 = 0, m = 0, r = 0;
		UEdge ae = null; boolean flag = true, method = true;
		
		while(i < length) {
			
			ch = getPosition(txt[i]);
			System.out.println("I : "+i+" , txt - "+txt[i]);
			set = new HashSet<UEdge>();
			
			if(an.child[ch] == null) {
				an.child[ch] = new UTrie(true, ++nodeNo);
				an.edges[ch] = new UEdge(i, length - i);
				i++; an = root;
			} else {
				
				ae = an.edges[ch]; remain = 0; al = 0;
				m = ae.start; flag = true;

				while(flag) {

					while(m < ae.end && i < length && txt[m] == txt[i]) {
						al++; i++; remain++; m++;
					}
					System.out.print("In - I : "+i);
					System.out.println(" txt:"+txt[i]);
					System.out.println("M : "+m+" , AL : "+al+" , END : "+ae.end+" , pos : "+an.child[ch].child[getPosition(txt[i])]);
					
					if(m == ae.end) {
						set.add(ae);
						if(an.child[ch].child[getPosition(txt[i])] != null) {
							System.out.println("Came inside");
							al = 0; an = an.child[ch]; ch = getPosition(txt[i]);
							ae = an.edges[ch]; m = ae.start;
							if(txt[i] == txt[i - 1]) remain--;
						} else {
							method = false; // NO Split, Add new Node in the first child node
							break;
						}
					} else {
						method = true;
						break;
					}
					
				}	
				// case - 2 (partially equal) or case - 1 (e subset of en)
				if(method) {
					split1 = ae.start + al; split2 = i;
					r = process(an, ch, split1, split2, remain, al);
				} else {
					System.out.println("Came in NULL area");
					r = process2(an, ch, remain, al, i);
				}
				
				set.clear();
				i = i - r;
				
				an = root;
				changeColor();
			}
			
			printTree();
			System.out.println();
			changeColor();
		}
		
	}

	int process2(UTrie an, int chh, int remain, int al, int pos) {
		
		int alen = length - pos;
		if(alen < 1) alen = 1;
		
		an = an.child[chh];
		UEdge ae = an.edges[chh];
		int end = ae.end - 1, k = 0, k2;
		UTrie pre = null, ann = null;
		
		while(remain > 0) {
			
			k = end - al;
			int ch = getPosition(txt[k]);
			
			if(pre == an) return al;
			
			pre = an;
			ann = an.child[ch];
			
			k2 = getPosition(txt[pos]);
			ann.isLeaf = false;
			ann.child[k2] = new UTrie(true, ++nodeNo);
			ann.edges[k2] = new UEdge(pos, alen);
			
			al--; remain--;
			
			if(an.sLink != null) {
				System.out.println(" In s Links");
				an = an.sLink;
			} else {
				System.out.println(" IN s Links root");
				if(txt[k] != txt[k - al])
					an = root; 
			}
		}
		return 0;
	}
	
	int process(UTrie an, int chh, int spl1, int spl2, int remain, int al) {
		
		int ch  = 0, k = 0; 
		boolean update = false;
		UEdge ae = an.edges[chh];
		UTrie temp = null, sTemp = null;
		
	
		
		int split1 = spl1, split2 = spl2;
		int pch =  -1;
		int alen = 0;
		UTrie ann = null; boolean flag = true;
		
		while(remain > 0) {
			
			k = split2 - al;
			ch = getPosition(txt[k]);
			ae = an.edges[ch];
		//	alen = length - split1;
		//	alen = glen;
			alen = ae.len - al;
			
			System.out.println("Remainder : "+remain+", char : "+k+", txt : "+txt[k]+", al :"+al+", Clr : "+ae.color);
			
			if(pch == ch && an == ann) {
				System.out.println("In Same");
				split1--;
				alen = 1;
			} else if(set.contains(ae)) {
				System.out.println("Returning Back");
				return al;
			}
			
			/*
			 * Handle : ACACAA$
			 * 
			 * else if(an.child[ch].color != "white") {
			*/
			
			pch = ch; ann = an;
			

			System.out.println("Internal : "+ae.start+", "+(ae.start + al));
			System.out.println("Split 1 : "+split1+" ,Len : "+alen+" ,End : "+(split1 + alen));
			System.out.println("Split 2 : "+split2+" ,Len : "+(length - split2)+" ,End : "+length);
					
			if(flag) {
				
				UEdge ne = new UEdge(ae.start, al);
				UTrie nc = new UTrie(false, ++nodeNo);
				temp = an.child[ch];
				an.child[ch] = nc;
				an.edges[ch] = ne;
			//	ne.color = "grey";
				set.add(ne);
				
				nc.edges[getPosition(txt[split1])] = new UEdge(split1, alen);
				nc.child[getPosition(txt[split1])] = temp;
					
				nc.edges[getPosition(txt[split2])] = new UEdge(split2, length - split2);
				nc.child[getPosition(txt[split2])] = new UTrie(true, ++nodeNo);
				
				if(nc.sLink == null) {
					if(update) sTemp.sLink = nc;
					sTemp = nc;
					update = true;
				} 
				
			}
			
			remain--; al--; flag = true;			
			if(al < 1) al = 1;
			
			if(an.sLink != null) {
				System.out.println(" In s Links");
				an = an.sLink;
			} else {
				System.out.println(" IN s Links root");
				if(remain > 0 && txt[k] != txt[split2 - al])
					an = root; 
			}

			
			printTree();
			changeColor();
		}
		
		return 0;
	}
	
	public void changeColor() {

		Stack<UTrie> stack = new Stack<UTrie>();
//		Stack<UEdge> sEdge = new Stack<UEdge>();
		stack.push(root);
		while(!stack.isEmpty()) {
			
			UTrie t = stack.peek();
			for(int i = 0; i < t.SYMBOLS && !t.isLeaf; i++) {
				if(t.child[i] != null && t.child[i].color != "white") {
					t.child[i].color = "white";
					t.edges[i].color = "white";
					
					stack.push(t.child[i]);
					t = stack.peek();
					i = 0;
				}
			}
			
			stack.pop();
		}
	}
	
	
	public ArrayList<String> printTree() {
	
		System.out.println("In vizualize..");
		
		ArrayList<String> list = new ArrayList<String>();
		
 		UTrie trie = root; UEdge ae = null;
		Stack<UTrie> stack = new Stack<UTrie>();
		Stack<UEdge> sEdge = new Stack<UEdge>();
		
		stack.push(trie);
		
		int wCount = 0;
		while(!stack.isEmpty()) {
			
			UTrie t = stack.peek();
			for(int i = 0; i < t.SYMBOLS; i++) {
				if(t.child[i] != null && t.child[i].color == "white") {
				
					t.child[i].color = "grey";
					stack.push(t.child[i]);
					sEdge.push(t.edges[i]);

					t = stack.peek();
					wCount++;
					i = -1;
					
				}
			}

			t = stack.peek();
			
			if(t != root) {
				ae = sEdge.peek();
				sEdge.pop();
				System.out.println(wCount+ " " +text.substring(ae.start, ae.end));
			}
			
			t.color = "black";
			stack.pop();
			wCount--;
		}
		
		return list;
	}
}
