package java_exercise;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
	
	
	/*
	 *  Permutations
	 *  
	 *  Given a collection of distinct numbers, return all possible permutations.

	 * For example,
	 * [1,2,3] have the following permutations:
	 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
	 */
	
	//helper function: convert int[] to List object
	public ArrayList<Integer> convertToList(int[] nums) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if(nums.length == 0) return list;
		for (int i = 0; i < nums.length; i++) {
			list.add(nums[i]);
		} 
		return list;
	}
	

	public void permuteHelper(int[] nums, List<List<Integer>> res, int start) {
		if(start == nums.length-1) {
			ArrayList<Integer> permute = convertToList(nums);
			res.add(permute);
		} else {
			for (int i = start; i <= nums.length-1; i++) {
				//swap the number at index start with every single number to its right
				//to get all the permutations. 
				int temp = nums[start];
				nums[start] = nums[i];
				nums[i] = temp;
				
				permuteHelper(nums, res, start+1);
				
				temp = nums[start];
				nums[start] = nums[i];
				nums[i] = temp;
			}
		}
	}
	
	
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		permuteHelper(nums, result, 0);
        return result;
    }
	

	/*
	 * Permutations II
	 * 
	 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.

	 * For example,
	 * [1,1,2] have the following unique permutations:
	 * [1,1,2], [1,2,1], and [2,1,1].
	 */
	
	
	//if the number at index index has been visited before or is the same as the number at index start,
	// we skip it to avoid duplication.
	public boolean visited(int[] nums, int start, int index) {
		for (int i = start; i < index; i++) {
			if(nums[i] == nums[index]) return true;
		}
		return false;
	}
	
	public void permuteUniqueHelper(int[] nums, List<List<Integer>> res, int start) {
		if(start == nums.length-1) {
			ArrayList<Integer> permute = convertToList(nums);
			res.add(permute);
		} else {
			for (int i = start; i <= nums.length-1; i++) {
				//swap the number at index start with every single number to its right
				//to get all the permutations. 
				if(!visited(nums, start, i)) {
					int temp = nums[start];
					nums[start] = nums[i];
					nums[i] = temp;
					
					permuteUniqueHelper(nums, res, start+1);
					
					temp = nums[start];
					nums[start] = nums[i];
					nums[i] = temp;
				}
			}
		}
	}
	
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		permuteUniqueHelper(nums, result, 0);
        return result;
    }
}