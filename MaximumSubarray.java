package java_exercise;

public class MaximumSubarray {

	/*
	 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

	 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
	 * the contiguous subarray [4,−1,2,1] has the largest sum = 6.
	 */
	
	// for an array A[0, i], if there is a k so that the sum from A[k] to A[i] is the maximum,
	// we define it as max[i]. Then max[i+1] = max[i] + A[i+1] if (max[i] + A[i+1] > 0) or = 0
	// if max[i+1] < 0. Because if max[i+1] < 0, A[i+1] must be a negative number. So we drop it. 
	
	//O(n) Solution
	public int maxSubArray(int[] nums) {
		int sum = 0, max = Integer.MIN_VALUE;
		for (int i : nums) {
			sum += i;
			if (sum > max) max = sum;
			if (sum < 0) sum = 0;
		}
		return max;
	}
	
	
	//Divide and Conquer Solution
	
}
