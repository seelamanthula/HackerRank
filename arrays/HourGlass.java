package arrays;

import java.util.Scanner;

public class HourGlass {

	public static void main(String[] args) {
		int rows = 6, cols = 6;
	    int[][] a = new int[rows][cols];
	    Scanner scan = new Scanner(System.in);
	    
	    for(int i = 0; i < rows; i++) {
	    	for(int j = 0; j < cols; j++) {
	    		a[i][j] = scan.nextInt();
	    	}
	    }
	    int hr, hc, k, s = -64, r, c;
	    for(r = 0; r < rows - 2; r++) {
	      hr = r;  
	      for(c = 0; c < cols - 2; c++) {
	          k = 0;
	          for(hc = c; hc <= c + 2; hc++) {
	            k += a[hr][hc] + a[hr + 2][hc];
	          }
//	          k = a[hr][c] + a[hr][c + 1] + a[hr][c + 2] + a[hr + 2][c] + a[hr + 2][c + 1] + a[hr + 2][c + 2];
	          k += a[hr + 1][c + 1];
	          if(k > s)
	              s = k;
	      }  
	    }
	    
	    System.out.println("Answer :"+s);
	}
}
