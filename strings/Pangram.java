package strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Pangram {

	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 * 
	 */
	 public static void main(String[] args) throws IOException {
	        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
	        
	        Scanner sc = new Scanner(System.in);
	      //  String s = sc.next();
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        String s = br.readLine();
	        
	        boolean[] count = new boolean[26];
	        int k = 0, c;
	        
	        for(int i = 0; i < 26; i++)
	            count[i] = false;
	        
	        for(int i = 0; i < s.length(); i++) {
	            if(s.charAt(i) != ' ') {
	                c = (int) s.charAt(i);
	                k = (c < 92)? 65: 97;
	               System.out.println((c-k)+" "+c); 
	                    count[c - k] = true;
	            }
	        }
	        
	        for(int i = 0; i < 26; i++) {
	        	System.out.println((i+1)+" "+count[i]);
	        }
	        boolean flag = true;
	        
	        for(int i = 0; i < 26 && flag; i++) {
	            if(!count[i]) {
	                flag = false;
	            }
	            
	            System.out.println((i + 1)+" "+count[i]);
	            
	        }
	        
	        if(flag) {
	            System.out.println("panagram");
	        } else {
	            System.out.println("not panagram");
	        }
	    }

}
