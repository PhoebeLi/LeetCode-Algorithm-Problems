package java_exercise;

public class UniquePaths {

	/*
	 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
	
	 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
	
	 * How many possible unique paths are there?
	 */
	
	public int uniquePaths(int m, int n) {
		 if (m == 0 | n == 0) return 1;
		 
		 //paths[i][j] = the number of unique paths from the start grid to current grid.
		 int [][] paths = new int[m][n];
		 
		 paths[0][0] = 1;
		 for (int i = 0; i < m; i++) {
			paths[i][0] = 1;
		}
		 
		 for (int i = 0; i < n; i++) {
			paths[0][i] = 1;
		}
		 for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				paths[i][j] = paths[i-1][j] + paths[i][j-1];
			}
		}
		
		 return paths[m-1][n-1];
	 }
	
	
	/*
	 * Follow up for "Unique Paths":

	 * Now consider if some obstacles are added to the grids. How many unique paths would there be?

	 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.

	 * For example,
	 * There is one obstacle in the middle of a 3x3 grid as illustrated below.

	 * [
	    [0,0,0],
	    [0,1,0],
	    [0,0,0]
	   ]
	 * The total number of unique paths is 2.
	 */
	
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if (m == 0) return 0;
        int n = obstacleGrid[0].length;
        if (n == 0) return 0;
        
        if (obstacleGrid[0][0] == 1) return 0;
        int [] res = new int[n];
        for(int i = 0; i < n; i++) {
        	res[i] = 0;
        }
        res[0] = 1;
        for(int i = 0; i < m; i++) { // for each row
            for(int j = 0; j < n; j++) { // for each element in that row
                
                if (obstacleGrid[i][j] == 1 ) { // once it's zero, it's always zero
                    res[j] = 0;
                } else if (j > 0){
                    res[j] = res[j - 1] + res[j];
                }
            }
        }
        
        return res[n - 1];
    
    }
	
}
