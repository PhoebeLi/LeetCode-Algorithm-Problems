package java_exercise;

public class TrappinRainWater {

	/*
	 * https://leetcode.com/problems/trapping-rain-water/
	 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

	 * For example, 
	 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
	 * 
	 * reference: http://www.programcreek.com/2014/06/leetcode-trapping-rain-water-java/
	 */
	
	//For each bar, the water it can trap depend on the max height on its left and right.
	//
	//Scan the map from left and right and record the max height on left and right for each bar.
	//Scan the array left and right to get the trapped water.
	
	public int trap(int[] height) {
		if(height == null || height.length == 0) return 0;
		int len = height.length;
		
		// left[i] = the largest element to the left of element left[i]
		int [] left = new int[len];
		int max = height[0];
		left[0] = height[0];
		for (int i = 1; i < len; i++) {
			if(height[i] > max){
				max = height[i];	
			}
			left[i] = max;
		}
		
		// right[i] = the largest element to the right of the element right[i]
		int [] right = new int[len];
		max = height[len-1];
		right[len-1] = height[len-1];
		for(int i = len-2; i >=0; i--) {
			if(height[i] > max) {
				max = height[i];
			}
			right[i] = max;
		}
        
		//calculate total volume 
		int volume = 0;
		for (int i = 0; i < len; i++) {
			volume += Math.min(left[i], right[i])-height[i];
		}
		return volume;
    }

}
