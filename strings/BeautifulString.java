package strings;

import java.util.Scanner;

public class BeautifulString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        String s = sc.next();
        int count = 0;
        
        for(int i = 2; i < n; i++) {
            if(s.charAt(i - 2)== '0' && s.charAt(i - 1) == '1' && s.charAt(i) == '0') {
                s = s.substring(0,i)+ "1"+s.substring(i+1, n);
                ++count;                
            }
        }
        
        System.out.println(count);

	}

}
