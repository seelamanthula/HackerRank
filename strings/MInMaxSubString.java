package strings;

import java.util.Scanner;

public class MInMaxSubString {

	public static void main(String[] args) {
	    Scanner scan = new Scanner(System.in);
        String s1 = scan.next();
        int k = scan.nextInt();
        int m = s1.length();
        
        String min, s, max, temp, s2 ="";

        s = s1;
        
        min = s.subSequence(0, k) + "";
        max = min;
        for(int i = 1; i <= m - k ; i++) {
            temp = s.subSequence(i, i + k) + "";
            if(min.compareTo(temp) >= 0) 
                min = temp;
            
            if(max.compareTo(temp) < 0)
                max = temp;         
        }
        
        System.out.println(min);
        System.out.println(max);
	}
}
