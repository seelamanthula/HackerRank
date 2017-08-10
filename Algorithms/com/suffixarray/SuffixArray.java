package com.suffixarray;

/*
 * 
 * 		Input needed: Text String
 * 
 * 		Run time : O(|Text| log |Text|)
 * 		Memory : O(|Text|)
 * 
 */


public class SuffixArray {

	int SMALL = 97, SYMBOLS = 27;
	int k  = 0;
	
	private int[] sortCharacters(String s) {
		
		int[] order = new int[s.length()];
		int[] count = new int[SYMBOLS + 1];
		
		count[1] = 1;
		for(int i = 0; i < s.length() - 1; i++) {
			count[s.charAt(i) - SMALL + 2] += 1;
		}
		
		for(int i = 1; i < SYMBOLS + 1; i++) {
			count[i] += count[i - 1];
		}

		order[0] = s.length() - 1;
		for(int i = 0; i < s.length() - 1; i++) {
			k = s.charAt(i) - SMALL + 1;
			order[count[k]] = i;
			count[k]++;
		}
		
		return order;
	}

	private int[] findDifferentChars(String s, int[] order) {
		
		int[] d_class = new int[s.length()];
		char[] txt = s.toCharArray();
		
		d_class[order[0]] = 0;
		for(int i = 1; i < s.length(); i++) {
			if(txt[order[i]] == txt[order[i - 1]])
				d_class[order[i]] = d_class[order[i - 1]];
			else 
				d_class[order[i]] = d_class[order[i - 1]] + 1;
		}
		
		return d_class;
	}
	
	private int[] sortDoubled(String s, int[] order, int[] d_class, int L) {
		
		int[] n_order = new int[s.length()];
		int[] count = new int[s.length()];
		int n = s.length();
		
		for(int i = 0; i < n; i++) {
			count[d_class[i]] = count[d_class[i]] + 1;
		}
		
		for(int i = 1; i < n; i++) {
			count[i] =  count[i] + count[i - 1];
		}
		
		int start = 0, cl = 0;
		for(int i = n - 1; i >= 0; i--) {
			start = (order[i] - L + n) % n;
			cl = d_class[start];
			count[cl] = count[cl] - 1; // Decrtementing because of '0' based index
			n_order[count[cl]] = start;			
		}
		
		return n_order;
	}
	
	private int[] differentCharacters(int[] order, int[] d_class, int L) {
		
		int n = order.length, cur = 0, mid = 0, prev = 0, midPrev = 0;
		int[] n_d_class = new int[n];
		
		n_d_class[order[0]] = 0;
		for(int i = 1; i < n; i++) {
			
			cur = order[i]; prev = order[i - 1];
			mid = cur + L; midPrev = (prev + L) % n;
			
			if((d_class[cur] != d_class[prev]) || 
					(d_class[mid] != d_class[midPrev]))
				n_d_class[cur] = n_d_class[prev] + 1;
			else
				n_d_class[cur] = n_d_class[prev];
			
		}
		
		return n_d_class;
	}
	
	public int[] buildSuffixArray(String s) {
		
		int[] order = sortCharacters(s);
		int[] d_class = findDifferentChars(s, order);

		int L = 1;
		while(L < s.length()) {
			order = sortDoubled(s, order, d_class, L);
			d_class = differentCharacters(order, d_class, L);
			L = 2 * L;
		}
		
		return order;
	}
}
