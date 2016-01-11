package java_exercise;

public class ProductOfArrayExceptSelf {

	/*
	 * Given an array of n integers where n > 1, nums, return an array output such that 
	 * output[i] is equal to the product of all the elements of nums except nums[i].

	 * Solve it without division and in O(n).

	 * For example, given [1,2,3,4], return [24,12,8,6].
	 */
	
	public int[] productExceptSelf(int[] nums) {
		if(nums == null || nums.length == 0 || nums.length == 1) return new int[]{};
		
		int len = nums.length;
		
		//left[i] = the product of all the numbers to the left of number at index i
        int [] left = new int[len];
        left[0] = 1;
        for (int i = 1; i < len; i++) {
			left[i] = left[i-1]*nums[i-1];
		}
        
        //right[i] = the product of all the numbers to the right of number at index i.
        int [] right = new int[len];
        right[len-1] = 1;
        for(int i = len-2; i >= 0; i--) {
        	right[i] = right[i+1]*nums[i+1];
        }
        
        int [] products = new int[len];
        for (int i = 0; i < len; i++) {
			products[i] = left[i]*right[i];
		}
        return products;
    }
	
}
