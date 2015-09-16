package search;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle
 * containing all ones and return its area.
 * 
 * @author luoxiongcai
 *
 */
public class MaximalRectangle {
	/**
	 * 利用partSum，O(n^4).
	 * @param matrix
	 * @return
	 */
	public int maximalRectangle(char[][] matrix) {
	    if (matrix == null || matrix.length == 0) {
	      return 0;
	    }
	    int m = matrix.length;
	    int n = matrix[0].length;
	    int[][] partSum = new int[m + 1][n + 1];
	    for (int i = 1; i <= m; i++){
	    	for (int j = 1; j <= n; j++){
	    		partSum[i][j] = (matrix[i-1][j-1] - '0') + partSum[i-1][j] + partSum[i][j-1] - partSum[i-1][j-1];
	    	}
	    }
	    int max = 0;
	    for (int i = 0; i < m; i++){
	    	for (int j = 0; j < n; j++){
	    		for (int h = i; h <m; h++){
	    			for (int k = j; k < n; k++){
	    				int cur = partSum[h+1][k+1] - partSum[h+1][j] - partSum[i][k+1] + partSum[i][j];
	    				if (cur < (h - i +1)*(k - j + 1)) break;
	    				max = Math.max(max, cur);
	    			}
	    		}
	    	}
	    }
	    return max;
	}

	public static void main(String[] args) {
		MaximalRectangle mr = new MaximalRectangle();
	}

}
