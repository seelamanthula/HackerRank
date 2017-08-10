package com.week2.bwt;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * Its a linear time text compression algorithm and the best part is it regenerates the 
 * the compressed text to original text in linear time.
 * 
 * This compresses the text.
 * 
 * Run time : O(n) (uses counting sort)
 * Memory: O(n)
 */
public class InverseBWT {
    class FastScanner {
        StringTokenizer tok = new StringTokenizer("");
        BufferedReader in;

        FastScanner() {
            in = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (!tok.hasMoreElements())
                tok = new StringTokenizer(in.readLine());
            return tok.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    String inverseBWT(String bwt) {
        StringBuilder result = new StringBuilder();

        // write your code here
        int ASCII = 123;
        int[] count = new int[ASCII];
        int N = bwt.length();
        char[] t = bwt.toCharArray();
        
        for(int i = 0; i < N; i++)
        	count[t[i] + 1]++;
        
        for(int i = 1; i < ASCII; i++)
        	count[i] += count[i-1];
        
        int[] index = new int[N];
        char[] chs = new char[N];
        
        for(int i = 0; i < N; i++) {
        	index[count[t[i]]] = i;
        	chs[count[t[i]]] = t[i];
        	count[t[i]]++;
        }
        
        int pos = index[0];
        for(int i = 0; i < N; i++) {
        	result.append(chs[pos]);
        	pos = index[pos];
        }
        
        return result.toString();
    }

    static public void main(String[] args) throws IOException {
        new InverseBWT().run();
    }

    public void run() throws IOException {
        FastScanner scanner = new FastScanner();
        String bwt = scanner.next();
        System.out.println(inverseBWT(bwt));
    }
}
