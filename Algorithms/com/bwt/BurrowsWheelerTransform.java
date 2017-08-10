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
 * Run time : O(n) 
 * Memory: O(n)
 */
public class BurrowsWheelerTransform {
	
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

    String BWT(String text) {
        StringBuilder result = new StringBuilder();

        int n =  text.length();
        String s = text + text;
        String st[] = new String[n];
        
        for(int i = 0; i < n ; i++) {
        	st[i] = s.substring(i, n + i);
        }
        
        Arrays.sort(st);
        
        for(int i = 0; i < n ; i++) {
        	//System.out.println(st[i]);
        	result.append(st[i].charAt(n - 1));
        }
        
        return result.toString();
    }

    static public void main(String[] args) throws IOException {
        new BurrowsWheelerTransform().run();
    }

    public void run() throws IOException {
        FastScanner scanner = new FastScanner();
        String text = scanner.next();
        System.out.println(BWT(text));
    }
}

