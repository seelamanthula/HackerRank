package arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class SequenceList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int N, x, y, queries, lastAns = 0, seq;
		
	//	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		queries = scan.nextInt();
		
		int[][] arr = new int[queries][3];
		for(int i = 0; i < queries; i++)
			for(int j = 0; j < 3; j++)
				arr[i][j] = scan.nextInt();
		
		ArrayList[] aList = new ArrayList[N];
		for(int i = 0; i < N; i++) {
			aList[i] = new ArrayList();
		}
		
		int no;

		try {
			for(int r = 0; r < queries; r++) {
				
		//		System.out.println("\nQuery : "+i);

					no = arr[r][0];
					x = arr[r][1];
					y = arr[r][2];

				if(no == 1) {
		
					seq = (x ^ lastAns) % N;
	//				System.out.println(aList[seq]);
					aList[seq].add(y);
					
				} else if(no == 2) {
					
					seq = (x ^ lastAns) % N;
	//				System.out.println(aList[seq]);
					lastAns = (int) aList[seq].get(aList[seq].size() - 1);
					System.out.println(lastAns + " ");
					
				}			
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
