package strings;

import java.util.HashSet;
import java.util.Iterator;

//Java program to print all possible strings of length k
class PermutationDiffLength {

    public static HashSet hs = new HashSet();

 // Driver method to test below methods
 public static void main(String[] args) {             
     System.out.println("First Test");
     String s = "AAAAT";
     char set1[] = s.toCharArray();
     int k = 5;
     printAllKLength(set1, k);
          
 }    

 // The method that prints all possible strings of length k.  It is
 //  mainly a wrapper over recursive function printAllKLengthRec()
 static void printAllKLength(char set[], int k) {
     int n = set.length;
     printAllKLengthRec(set, "", n, k, hs);
     
     printHashSet();
	}

 static void printHashSet() {
	 Iterator iterate = hs.iterator();
		int i  = 1;
		while(iterate.hasNext()) {
			System.out.println(i++ +"  "+iterate.next());
		} 
 }
 
 // The main recursive method to print all possible strings of length k
 static void printAllKLengthRec(char set[], String prefix, int n, int k, HashSet hs) {
      
     // Base case: k is 0, print prefix
     if (k == 0) {
//         System.out.println(prefix);
         hs.add(prefix);
         return;
     }

     // One by one add all characters from set and recursively 
     // call for k equals to k-1
     for (int i = 0; i < n; ++i) {
          
         // Next character of input added
         String newPrefix = prefix + set[i]; 
          
         // k is decreased, because we have added a new character
         printAllKLengthRec(set, newPrefix, n, k - 1, hs); 
     }
 }
}