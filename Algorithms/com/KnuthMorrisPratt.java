import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class KnuthMorrisPratt {
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

    // Find all the occurrences of the pattern in the text and return
    // a list of all positions in the text (starting from 0) where
    // the pattern starts in the text.
    public List<Integer> findPattern(String pattern, String text) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        // Implement this function yourself
        int[] c = pattern(pattern);
        
        int M = pattern.length();
        int N = text.length();
 
        int lp[] = new int[M];
        int j = 0, i = 0;  

        lp = pattern(pattern);
 
        while(i < N) {

        	if(pattern.charAt(j) == text.charAt(i)) {
                
        		j++; i++;
                
                if(j == M) {
                    System.out.println(" "+(i - j));
                    j = lp[j-1];
                }
                
            } else if (i < N && pattern.charAt(j) != text.charAt(i))  {
                		
            	if(j != 0)
                    j = lp[j - 1];
                else
                    i = i + 1;
            }
        }
        
        return result;
    }

    public int[] pattern(String s) {
		
		int[] c = new int[s.length()];
		
		c[0] = 0;  
		for(int i = 1, k = 0; i < s.length(); i++) {
			
			while(k > 0 && (s.charAt(i) != s.charAt(k))) {
					k = c[k - 1];
				}
			
			if(s.charAt(i) == s.charAt(k)) k = k + 1;
			else k = 0;
			
			c[i] = k;
 		}
	
		return c;
	}
 
    static public void main(String[] args) throws IOException {
        new KnuthMorrisPratt().run();
    }

    public void print(List<Integer> x) {
        for (int a : x) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    public void run() throws IOException {
        FastScanner scanner = new FastScanner();
        String pattern = scanner.next();
        String text = scanner.next();
        List<Integer> positions = findPattern(pattern, text);
  //      print(positions);
    }
}
