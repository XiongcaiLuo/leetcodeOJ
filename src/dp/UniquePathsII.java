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
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if ( m == 0 || n ==0) return 0;
        int row0 = Integer.MAX_VALUE, col0 = Integer.MAX_VALUE;
        int[] step = new int[n];
        for (int i = 0; i<n ;i++){
        	if (obstacleGrid[0][i] == 1 || i > row0){
        		step[i] = 0;
        		row0 = i;
        	} else step[i] = 1;
        }
        for (int i = 0; i < m; i++){
        	if (obstacleGrid[i][0] == 1 ){
        		col0 = i;
        		break;
        	}
        }
        for (int i = 1; i < m; i++){
        	for (int j = 0 ; j < n; j++){
        		if (j == 0)
        			step[j] = i < col0 ? 1 : 0;
        		else{
        			step[j] = obstacleGrid[i][j] == 1 ? 0 : step[j-1] + step[j];
        		}
        	}
        }
        return step[n-1];
        
    }
    
    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if ( m == 0 || n ==0) return 0;
        int [] step = new int[n];
        step[0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int i = 0; i < m; i++){
        	for (int j = 0; j < n ; j++){
        		step[j] = obstacleGrid[i][j] == 1 ? 0 :(j == 0 ? 0 :step[j-1])+step[j];
        	}
        }
        return step[n-1];
        
    }
	public static void main(String[] args) {
		UniquePathsII up = new UniquePathsII();
		int[][] obstackle = {{0},{1}};
		int step = up.uniquePathsWithObstacles2(obstackle);
		System.out.println(step);
	}
}
