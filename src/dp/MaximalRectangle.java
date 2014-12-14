package dp;

public class MaximalRectangle {

	/**
	 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.
	 * @param args
	 */
	 public int maximalRectangle(char[][] matrix) {
		    if (matrix == null || matrix.length == 0) {
		      return 0;
		    }

		    int M = matrix.length;
		    int N = matrix[0].length;
		    int[] H = new int[N];
		    int[] L = new int[N];
		    int[] R = new int[N];
		    for (int i = 0; i < N; ++i) {
		      R[i] = N;
		    }

		    int ret = 0;
		    for (int i = 0; i < M; ++i) {
		      int left = 0, right = N;
		      // calculate L(i, j) from left to right
		      for (int j = 0; j < N; ++j) {
		        if (matrix[i][j] == '1') {
		          ++H[j];
		          L[j] = Math.max(L[j], left);
		        } else {
		          left = j + 1;
		          H[j] = 0;
		          L[j] = 0;
		          R[j] = N;
		        }
		      }

		      // calculate R(i, j) from right to left
		      for (int j = N - 1; j >= 0; --j) {
		        if (matrix[i][j] == '1') {
		          R[j] = Math.min(R[j], right);
		          ret = Math.max(ret, H[j] * (R[j] - L[j]));
		        } else {
		          right = j;
		        }
		      }
		    }

		    return ret;
		  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
