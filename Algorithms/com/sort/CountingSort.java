package com.sort;

public class CountingSort {

	int SYMBOLS = 27;
	
	/*
	 * Words only with albhabets of any case
	 */
	public String performSort(String s) {
		
		int[] c = new int[SYMBOLS];
		char[] chs = s.toCharArray();
		int ch = 0;
		for(int i = 0; i < s.length(); i++) {
			
			if(chs[i] < 92)
				ch = chs[i] - 65;
			else
				ch = chs[i] - 97;
			
			c[ch + 1]++;
		}
		
		for(int i = 1; i < SYMBOLS - 1; i++)
			c[i] += c[i-1];

		char[] fch = new char[SYMBOLS - 1];

		for(int i = 0; i < chs.length; i++) {

			if(chs[i] < 92) {
				ch = chs[i] - 65;
				fch[c[ch]] = (char)(ch + 65);
			} else {
				ch = chs[i] - 97;
				fch[c[ch]] = (char)(ch + 97);
			}
			c[ch]++;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < chs.length; i++)
			sb.append(fch[i]);
		
		return sb.toString();
	}
	
}
