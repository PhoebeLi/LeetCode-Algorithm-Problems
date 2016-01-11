package java_exercise;

public class PerfectSquares {

	/*
	 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) 
	 * which sum to n.

	 * For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
	 */
	
	
	//DP solution
	//let sqrs[i] stands for the least number of perfect squares numbers which sum to i
	//At each iteration, sqrs[i+j*j] should equal to the smaller one of sqrs[i]+1 and its current value.
	
	 public int numSquaresDP(int n) {
		int [] sqrs = new int[n+1];
		for (int i = 0; i < sqrs.length; i++) {
			sqrs[i] = Integer.MAX_VALUE;
		}
		 sqrs[0] = 0;
		 for (int i = 0; i < n; i++) {
			for (int j = 1; i+j*j <= n; j++) {
				sqrs[i+j*j] = Math.min(sqrs[i+j*j], sqrs[i]+1);
			}
		 }
		 
		 return sqrs[n];
	 }

	//recursion solution: easy to think of but very inefficient.
	 
	private class mutInteger{
		int i = 0;
		public mutInteger(int i) {
			this.i = i;
		}
		
		public int getValue() {
			return i;
		}
		
		public void setValue(int i) {
			this.i = i;
		}
	}
	
	 public int numSquares(int n) {
		 mutInteger smallest = new mutInteger(Integer.MAX_VALUE);
		 if(n == 1) return 1;
		 squaresHelper(n, 0, smallest);
		 return smallest.getValue();
	 }
	 
	 private void squaresHelper(int n, int numSqrs, mutInteger smallest) {
		 if(n == 0) {
			 if(numSqrs < smallest.getValue()) smallest.setValue(numSqrs);
		 }
		 for (int i = 1; i <= (int)Math.sqrt(n); i++) {
			 int cnt = (int)(n/Math.pow(i,2));
			 squaresHelper(n-cnt*((int)Math.pow(i,2)), numSqrs+cnt, smallest);
		 }		 
	 }

}
