package strings;

import java.util.Scanner;

public class StringReduction {

	public static void main(String[] args) {
		  Scanner scan = new Scanner(System.in);
	        String str = scan.next();
	        
	        boolean flag = false;
	        StringBuilder sb = null;
	        
	        while(!flag) {
		        sb = new StringBuilder();
		        int count = 1, n = str.length();
		        for(int i = 1; i < n; i++) {
		            if(str.charAt(i - 1) == str.charAt(i)) {
		                count++;
		                flag = true;
		            }
		            else {
		                if((count%2) == 1) {
		                    sb.append(str.charAt(i-1));
		                }
		                count = 1;
		            }
		        }
		    
		        if((count%2) == 1)
		            sb.append(str.charAt(n-1));
		        
		        if(flag && sb.length() > 1) {
		        	str = sb.toString();
		        	flag = false;
		        } else {
		        	flag = true;
		        }
		    }
	       
	      if(sb.length() == 0)
	        	System.out.println("Empty String");
	        else
	        	System.out.println(sb);
	}
}
