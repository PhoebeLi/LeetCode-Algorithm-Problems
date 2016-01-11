package java_exercise;

/*
 * ************* Candy *************
 * There are N children standing in a line. Each child is assigned a rating value.

 * You are giving candies to these children subjected to the following requirements:

 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 */

public class Candy {
	
	//scan ratings from both sides to avoid the situations where we will give wrong number of candies.
	//e.g., ratings = [2,1], if we scan from left only, both children will be give 1 candies, which 
	//violate the problem.
	public int candy(int[] ratings) {
		if(ratings == null || ratings.length == 0) return 0;
		int [] left = new int[ratings.length];
		left[0] = 1;
		
		//scan the array from left
		//if child i has higher ratings than his left neighbor, he get one more candy than its right neighbor;
		//otherwise, child i gets one candy.
		for (int i = 1; i < ratings.length; i++) {
			if(ratings[i] > ratings[i-1]) {
				left[i] = left[i-1]+1;
			}else {
				left[i] = 1;
			}
		}
		
		//scan the array from right
		//if child i has higher ratings than his right neighbor, he get one more candy than its right neighbor;
		//otherwise, child i gets one candy.
		int [] right = new int[ratings.length];
		right[ratings.length-1] = 1;
		for (int i = ratings.length-2; i >=0; i--) {
			if(ratings[i] > ratings[i+1]) {
				right[i] = right[i+1]+1;
			} else {
				right[i] = 1;
			}
		}
		
		int result = 0;
		for (int i = 0; i < ratings.length; i++) {
			result += Math.max(left[i], right[i]);
		}
		return result;
	}

}
