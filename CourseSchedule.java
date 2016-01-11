package java_exercise;

import java.util.LinkedList;

public class CourseSchedule {

	/*
	 * There are a total of n courses you have to take, labeled from 0 to n - 1.

	 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

	 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

	 * For example:

	 * 2, [[1,0]]
	 * 	There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

	 * 2, [[1,0],[0,1]]
	 * There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
	 */

	
		// This problem is similar to finding cycle in a graph.
		// We solve this problem using BFS.
		//pCounter: index = the ID of the course; 
		//  		value = the indegree of that course(# of courses which require this course as their preRequest)
		
		//queue: all of the ID of the courses that does not have prerequests.
		public boolean canFinish(int numCourses, int[][] prerequisites) {
			if (prerequisites == null) {
				throw new IllegalArgumentException("no prerequisites list!");
			}
			
			int len = prerequisites.length;
			if (numCourses == 0 || len == 0) {
				return true;
			}
			
			int [] pCounter = new int[numCourses];

			for (int i = 0; i < len; i++) {
				pCounter[prerequisites[i][0]] ++;
			}
			
			LinkedList<Integer> queue = new LinkedList<Integer>();
			for (int i = 0; i < pCounter.length; i++) {
				if (pCounter[i] == 0) {
					queue.add(i);
				}
			}
			
			int numNoPre = queue.size();
			while(!queue.isEmpty()) {
				int top = queue.remove();
				for (int i = 0; i < len; i++) {
					// if a course's prerequisite can be satisfied by a course in queue
					if (prerequisites[i][1] == top) {
						pCounter[prerequisites[i][0]] --;
						if (pCounter[prerequisites[i][0]] == 0) {
							numNoPre ++;
							queue.add(prerequisites[i][0]);
						}
					}
				}
			}
	        return (numNoPre == numCourses);
	    }
}
