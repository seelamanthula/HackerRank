package com.suffixarray;

/*
 * 
 * 		Input needed: Suffix Array and Text	
 * 
 * 		Run time : O(|Text|)
 * 		Memory : O(|Text|)
 * 
 */

public class LCP {

	public int[] computeLCPArray(String s, int[] sarray) {

		int lcp = 0, suffix, nextSuffix, n = s.length();
		int[] lcpArray = new int[n - 1];
		
		int[] posInOrder = invertedSuffixArray(sarray);
		
/*		System.out.println("Indexes..");
		for(int i = 0; i < posInOrder.length; i++)
			System.out.println(i+" "+sarray[i]+" "+posInOrder[i]);*/
		
		suffix = sarray[0];
		for(int i = 0, orderIndex = 0; i < n; i++) {
			
			orderIndex = posInOrder[suffix];
			
			if(orderIndex == n - 1) {
				lcp = 0;
				suffix = (suffix + 1) % n;
				orderIndex = posInOrder[suffix];
			}
			
	//		System.out.println("\nOrder Ind : "+orderIndex);
			nextSuffix = sarray[orderIndex + 1];

	//		System.out.println("Suffixes : "+suffix+", "+nextSuffix+" LCP : "+lcp);

			lcp = LCPOfSuffixes(s, suffix, nextSuffix, lcp - 1);
			lcpArray[orderIndex] = lcp;
			suffix = (suffix + 1) % n;

			/*		System.out.print("  LCP Array -- ");
			prineArray(lcpArray);
			 */
		}

		return lcpArray;
	}
	
	public void prineArray(int[] arr) {

		for(int i = 0; i < arr.length; i++)
			System.out.print(" "+arr[i]);
		System.out.println();

	}
	
	private int LCPOfSuffixes(String s, int i, int j, int equal) {
	
		int lcp = equal;
		if(lcp < 0) lcp = 0;
		
		while((i + lcp) < s.length() && (j + lcp) < s.length()) {
			if(s.charAt(i + lcp) == s.charAt(j + lcp))
				lcp++;
			else 
				break;
		}
		
		return lcp;
	}
	
	private int[] invertedSuffixArray(int[] arr) {
		
		int[] pos = new int[arr.length];
		for(int i = 0; i < arr.length; i++)
			pos[arr[i]] = i;
		
		return pos;
	}
}
