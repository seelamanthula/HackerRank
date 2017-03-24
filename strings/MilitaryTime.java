package strings;

import java.util.Scanner;

public class MilitaryTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		   
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        
        String sb1 = str.substring(8);
       // StringBuilder[] sb2 = new StringBuilder(str.substring(0,8)).split(":");
        String[] sb2 = new String(str.substring(0,8)).split(":");
        
        int hh = Integer.parseInt(sb2[0]+"");
        System.out.println(sb1);
        if(sb1.equals("AM")) {
            if(hh == 12)
               hh = 00;
        } else {
            if(hh == 12)
                hh = 12;
            else
                hh = 12 + hh;
        }
        
        sb2[0] = String.format("%02d", hh)+":";
        sb2[1] = sb2[1]+":";
        
        for(int i = 0; i < 3; i++)
            System.out.print(sb2[i]);
        
	}

}
