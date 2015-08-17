package list;

import java.util.Arrays;

/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0.
 * Do it in place.
 * 
 * click to show follow up.
 * 
 * Follow up: Did you use extra space? A straight forward solution using O(mn)
 * space is probably a bad idea. A simple improvement uses O(m + n) space, but
 * still not the best solution. Could you devise a constant space solution?
 * 一个很神奇的想法，就是复用第一行，第一列来记录就可以了！！好巧妙的想法！
 * 
 * @param args
 */
public class SetMatrixZeroes {

	/**
	 * not very clean
	 * @param matrix
	 */
	public static void setZeroes(int[][] matrix) {
		if (matrix.length == 0)
			return;
		boolean rowZero = false, colZero = false;
		int row = matrix.length;
		int col = matrix[0].length;
		for (int i = 0; i < row; i++) {
			if (matrix[i][0] == 0) {
				colZero = true;
				break;
			}
		}
		for (int i = 0; i < col; i++) {
			if (matrix[0][i] == 0) {
				rowZero = true;
				break;
			}
		}

		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				if (matrix[i][j] == 0) {
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
			}
		}

		// check zero
		for (int i = 1; i < col; i++) { // be careful about the "1", not "0"
			if (matrix[0][i] == 0) {
				for (int j = 0; j < row; j++)
					matrix[j][i] = 0;
			}
		}

		for (int i = 1; i < row; i++) {
			if (matrix[i][0] == 0) {
				for (int j = 0; j < col; j++)
					matrix[i][j] = 0;
			}
		}

		if (rowZero) {
			for (int i = 0; i < col; i++) {
				matrix[0][i] = 0;
			}
		}
		if (colZero) {
			for (int i = 0; i < row; i++) {
				matrix[i][0] = 0;
			}
		}

	}
	
	public static void setZeroes2(int[][] matrix) {
		int m = matrix.length; 
		int n = matrix[0].length;
		int[] rows = new int[m];
		int[] cols = new int[n];
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				if (matrix[i][j] == 0){
					rows[i] = 1;
					cols[j] = 1;
				}
		for (int i = 0; i < m; i++)
			if (rows[i] == 1)
				Arrays.fill(matrix[i], 0);
		for (int j = 0; j < n; j++)
			if (cols[j] == 1){
				for (int i = 0; i <n; i++)
					matrix[i][j] = 0;
			}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
