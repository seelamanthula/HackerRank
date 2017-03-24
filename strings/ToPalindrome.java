package strings;

import java.util.Scanner;

public class ToPalindrome {
	 public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int k = in.nextInt();
	        String number = in.next();
	        
         StringBuilder sb = new StringBuilder(number);
	      if(n == 1) {
             if(k > 0)
                 sb.replace(0, 1, "9");
             
             System.out.println(sb);
         } else {
             
             for(int i = (n/2)-1; i >= 0 && k > 0; i--) {
                 char c1 = sb.charAt(i);
                 char c2 = sb.charAt(n-i-1);
                 
                 if(c1 != c2) {
	                 if(c1 > c2) {
	                     sb.replace(n-i-1, n-i, c1+"");
	                 } else {
	                     sb.replace(i, i + 1, c2+"");
	                 }
	                 --k; 
                 }
             }
             
        //     System.out.println("K1 : "+k+" SB : "+sb);
             
             if(k > 0) {
                 for(int i = 0; i < n/2 && k > 0; i++) {
                     char c1 = number.charAt(i);
                     char c2 = sb.charAt(i);
                     
                     if(c1 != c2 && c2 != '9') {
                         sb.replace(i, i + 1, "9");
                         sb.replace(n-i-1, n-i, "9");
                         --k;
                     }
                 }
             }
             
             
          //   System.out.println("K2 : "+k+" SB : "+sb);             
             boolean flag = true;
             for(int i = 0; i < n/2 && flag; i++) {
                 if(sb.charAt(i) != sb.charAt(n-i-1))
                     flag = false;
             }
         
             if(n%2 == 1 && k > 0) {
                 int l = (n+1)/2;
                 sb.replace(l, l + 1, "9");
                 --k;
             }

             if(!flag)
                 System.out.println("-1");
             else
                 System.out.println(sb);
         }
         
	      
	    }
}
