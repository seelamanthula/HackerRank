package strings;

import java.util.Scanner;

public class FunnyString {

	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        while(n > 0) {
            String s = sc.next();
            if(find(s)) {
                System.out.println("Funny");
            } else {
                System.out.println("Not Funny");
            }
        }
    }
    
    public static boolean find(String s) {
        int n = s.length();
       // String r = 
        for(int  i= 1; i< (n/2 + 1); i++) {
        	//System.out.println(s.charAt(i)+" "+s.charAt(i - 1)+" "+(s.charAt(i)-s.charAt(i - 1)));
        	//System.out.println(s.charAt(n -i)+" "+s.charAt(n - i - 1)+" "+(s.charAt(n-i)-s.charAt(n-i - 1)));        	
            if(Math.abs((s.charAt(i) - s.charAt(i-1))) != Math.abs((s.charAt(n-i) - s.charAt(n-i-1))))
                return false;
        }
        return true;
    }
    
}
