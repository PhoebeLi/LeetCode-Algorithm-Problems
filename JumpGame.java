package java_exercise;

public class JumpGame {

	/*
	 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

	 * Each element in the array represents your maximum jump length at that position.

	 * Determine if you are able to reach the last index.

	 * For example:
	 * A = [2,3,1,1,4], return true.
	 * A = [3,2,1,0,4], return false.
	 */
	
	
	//recursion version 
	public boolean canJumpRer(int[] nums) {
        return jumpHelper(nums, 0);
    }
	
	public boolean jumpHelper(int[] nums, int index) {
		if(index == nums.length-1) return true;
		if(nums[index] == 0) return false;
		
		for (int i = 1; i <= nums[index]; i++) {
			if(jumpHelper(nums, index+i)) {
				return true;
			}
		}
		return false;
	}
	
	
	 // iteration version
	 // the situation that the end of the array cannot be reached: max<=i && nums[i] == 0;
	 // reference: http://www.programcreek.com/2014/03/leetcode-jump-game-java/
	 
	 public boolean canJumpItr(int[] nums) {
		 if(nums == null || nums.length <= 1) return true;
		 
		 //max stands for the largest index that can be reached so far.
		 int max = nums[0]; 
		 for (int i = 0; i < nums.length; i++) {
			if(max <= i && nums[i] == 0) return false;
			
			if((i+nums[i]) > max) {
				max = i+nums[i];
			}
			
			if(max >= (nums.length-1)) return true;
		}
		 return false;
	 }

}
