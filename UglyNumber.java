package java_exercise;

import java.util.PriorityQueue;


public class UglyNumber {
	/*
	 * Write a program to find the n-th ugly number.
	
	 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 
	 * For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
	
	 * Note that 1 is typically treated as an ugly number.
	 */
	
	// an ugly number must be multiplied by either 2,3 or 5 from a smaller ugly number.
	public int nthUglyNumber(int n) {
		 int [] uglys = new int[n];
		 uglys[0] = 1;
		 int p2 = 0, p3 = 0, p5 = 0, index = 0;
		 while(index < n-1) {
			 int ugly2 = uglys[p2]*2, ugly3 = uglys[p3]*3, ugly5 = uglys[p5]*5;
			 int uglyMin = Math.min(ugly2, Math.min(ugly3, ugly5));
			 if(uglyMin == ugly2) p2++;
			 if(uglyMin == ugly3) p3++;
			 if(uglyMin == ugly5) p5++;
			 if(uglys[index] != uglyMin) uglys[++index] = uglyMin;
		 }
		 return uglys[n-1];
	 }

	
	
	
	/*
	 * Super Ugly Number
	 * Write a program to find the nth super ugly number.

	 * Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k. 
	 * For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] is the sequence of the first 12 super ugly numbers 
	 * given primes = [2, 7, 13, 19] of size 4.

	 * Note:
	 * (1) 1 is a super ugly number for any given primes.
	 * (2) The given numbers in primes are in ascending order.
	 * (3) 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.
	 * 
	 * reference: http://www.hrwhisper.me/leetcode-super-ugly-number/
	 */
	
	
	 class Node implements Comparable<Node> {
		 int index; // the index of the num in the uglys that has been calculated before
		 int prime; // the prime in the primes 
		 int val;   // the product of num with index "index" in the uglys and prime
		 
		 Node(int index, int prime, int val) {
			 this.index = index;
			 this.prime = prime;
			 this.val = val;
		 }
		 
		@Override
		public int compareTo(Node o) {
			if(this.val < o.val) return -1;
			else if(this.val == o.val) return 0;
			else return 1;
		}
		 
	 }
	 
	 
	 // use heap to store all of the generated primes to improve efficiency.
	 public int nthSuperUglyNumber(int n, int[] primes) {
		 PriorityQueue<Node> heap = new PriorityQueue<Node>();
		 int [] uglys = new int[n];
		 uglys[0] = 1;
		 
		 for (int i = 0; i < primes.length; i++) {
			heap.add(new Node(0, primes[i], primes[i]));
		 }
		 
		 for (int i = 1; i < n; i++) {
			Node cur = heap.peek();
			uglys[i] = cur.val;
			do{
				cur = heap.poll();
				cur.val = uglys[++cur.index]*cur.prime;
				heap.add(cur);
			}while(!heap.isEmpty() && heap.peek().val == uglys[i]);
		 }
		 
		 return uglys[n-1];
	 }

	 
	/*
	 * Ugly Number
	 * Write a program to check whether a given number is an ugly number.

	 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 
	 * For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.

	 * Note that 1 is typically treated as an ugly number.
	 */
	 
	 public boolean isUgly(int num) {
		 if(num < 1) return false;
		 if(num == 1) return true;
		 
		 while(num%2 == 0) num /= 2;
		 while(num%3 == 0) num /= 3;
		 while(num%5 == 0) num /= 5;
		 if (num == 1) return true;
	     return false;
	 }

}
