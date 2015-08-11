package dp;
/**
 * Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.
 * @author luoxiongcai
 *
 */
public class UniquePaths2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if ( m == 0 || n ==0) return 0;
        int [] step = new int[n];
        boolean ob_row = obstacleGrid[0][0] == 1;
        boolean ob_col = obstacleGrid[0][0] == 1;
        for(int i = 0; i < n; i++){
        	ob_row = (obstacleGrid[0][i] == 1 || ob_row) ? true : false;
        	step[i] = ob_row ? 0 : 1;
        }
        for ( int i = 1; i < m; i++){
        	for (int j = 0; j < n; j++){
        		if (j == 0){
        			ob_col = (ob_col || obstacleGrid[i][0] == 1) ? true : false;
        			step[j] = ob_col ? 0 : 1;
        		} else {
        			step[j] = obstacleGrid[i][j] == 1 ? 0 : step[j] + step[j-1];
        		}
        	}
        }
        return step[n-1];
    }
	public static void main(String[] args) {
		UniquePaths2 up = new UniquePaths2();
		int[][] obstackle = {{1},{0}};
		int step = up.uniquePathsWithObstacles(obstackle);
		System.out.println(step);
	}
}
