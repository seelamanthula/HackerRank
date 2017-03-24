package strings;

import java.util.Scanner;

public class SteadyGenePerfect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String s = sc.next();
		
		System.out.println(getMinimumSubstring(n, s));
	}

	 public static int getMinimumSubstring(int n, String s)
	    {
	        int mx = n / 4;

			int[] cnt = new int[20];

			for(int i = 0; i < n; i++) {
				char c = s.charAt(i);
				cnt[(int) c - 65] += 1;
			}
			
			boolean flag = true;
			
			for(int i = 0; i < 20; i++) {
				if(cnt[i] > mx)
					flag = false;
			}

			if (flag) 			
				return 0;		
	       
	        return getMinimumLength(cnt, n, mx, s); 
	    }   

	    /*
	     * sliding window: 
	     * start pointer: l
	     * end pointer:   r
	     * 
	     * For example: 
	     * GAAATAAA
	     * 
	     * windows l=0, r=0, size of window is 0; 
	     * 
	     * First, loop on start pointer l, 
	     * when l = 0, keep the start pointer as is, move end pointer until the rest of string
	     * satisfies condition: any char in "ACGT"'s count <= mx, for test case GAAATAAA, mx =2 
	     * 
	     * r = 6, exit while loop inside for loop
	     * sliding windows is l=0, r=6. 
	     * In other words, string "GAAATA" is one of strings. 
	     * 
	     * Then, sliding window's start pointer l increases to next value 1, and then, repeat the process. 
	     * "AAATA" is also one of strings, but length is shorter than "GAAATA". 
	     */
	    private static int getMinimumLength(int[] cnt, int n, int mx, String s)
	    {
	        int r = 0; 
	        int ans = n;
	        
	        System.out.println("L r A C G T ans");
	        for (int k = 0; k < n; k++) 
	        {
	            System.out.println(k+" "+r+" "+cnt['A'-65]+" "+cnt['C' - 65]+" "+cnt['T' - 65]+" "+cnt['G' - 65]+" "+ans);

	        	while (cnt['A' - 65] > mx || cnt['C' - 65] > mx || cnt['T' - 65] > mx || cnt['G' - 65] > mx)
	            {
	                if (r == n)
	                {
	                    return ans;
	                }

	                --cnt[s.charAt(r) - 65];
	                ++r;
		            System.out.println("  "+r+" "+cnt['A'-65]+" "+cnt['C' - 65]+" "+cnt['T' - 65]+" "+cnt['G' - 65]+" ");

	            }
	        	System.out.println("Ans : "+ans+ " R : "+(r-k));
	        	ans = Math.min(ans, (r-k));
	        	
	            ++cnt[s.charAt(k) - 65];
	            
	        }

	        return ans; 
	    }
	}

