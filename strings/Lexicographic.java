package strings;

public class Lexicographic {

	public static void main(String[] args) {
		
		String A = "hello";
		String B = "java";
		

		System.out.println(B.compareTo(A));
		
		int a = 'A';
		System.out.println(a);
		
		int b = 'a';
		System.out.println(b);
		
		
		int c = A.charAt(0);
		int d = B.charAt(0);		
		
		int m = A.length();
		int n = B.length();
		
		System.out.println((char) (a - 32) + "" + A.subSequence(1, m) + " "+ (char) (b - 32) + B.subSequence(1,n));
	}
}
