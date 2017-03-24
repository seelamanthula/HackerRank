package strings;

import java.util.Arrays;
import java.util.Scanner;

public class TwoCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        String s = in.next();
        
        int[] a = new int[26];
        
        for(int i = 0; i < len; i++) {
            int c = (int) s.charAt(i);
            int k = c - 97;
            a[k] += 1;
        }
        
        System.out.println("Before sort");
        for(int i  =0; i < 26; i++)
        	System.out.println(i+1+ " "+a[i]);
        
        Arrays.sort(a);
        
        System.out.println("After sort");
        for(int i  =0; i < 26; i++)
        	System.out.println(i+1+ " "+a[i]);
        
        int found = 0;
        
        for(int i = 24; i >= 0; i--) {
            if(a[i+1]-a[i] == 1) {
                found = a[i];
                break;
            }
        }
        
        System.out.println(found*(found + 1));
        
	}

}
