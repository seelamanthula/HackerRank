package arrays;

import java.util.Scanner;

public class SparseArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        int tc, dim, ope, x1, x2, y1, y2, z1, z2;
        long w, k;
        Scanner sc = new Scanner(System.in);
        tc = sc.nextInt();
        
        while(tc > 0) {
            dim = sc.nextInt();
            long[][][] a = new long[dim][dim][dim];
            
            ope = sc.nextInt();
            while(ope > 0) {
                
                String st = sc.next();
             //   System.out.println("Operation : "+ope);
                if(st.equals("UPDATE")) {
                    x1 = sc.nextInt();
                    y1 = sc.nextInt();
                    z1 = sc.nextInt();
                    w = sc.nextLong();
           //         System.out.println("UPDATE "+x1+" "+y1+" "+z1+" "+w);
                    a[x1 - 1][y1 - 1][z1 - 1] = w; 
                } else if(st.equals("QUERY")) {
                    x1 = sc.nextInt();
                    y1 = sc.nextInt();
                    z1 = sc.nextInt();
                    x2 = sc.nextInt();
                    y2 = sc.nextInt();
                    z2 = sc.nextInt();
           //         System.out.println("QUERY "+x1+" "+y1+" "+z1+" "+x2+" "+y2+" "+z2);

                    k = 0;                   
                    for(int i = x1 - 1; i < x2; i++) {
                        k += a[i][i][i];
                    }
                    System.out.println(k);
                }
                
                --ope;
            }
            
            --tc;
        }
        

	}

}
