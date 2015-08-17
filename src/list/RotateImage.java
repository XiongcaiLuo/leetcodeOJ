package list;

/**
 * You are given an n x n 2D matrix representing an image.
 * 
 * Rotate the image by 90 degrees (clockwise).
 * 
 * Follow up: Could you do this in-place?
 * 
 * @param args
 */
public class RotateImage {

	public static void rotate(int[][] matrix) {
		if (matrix.length == 1)
			return;
		int len = matrix.length;
		for (int i = 0; i < len - 1; i++) {
			for (int j = 0; j < len - i - 1; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[len - 1 - j][len - 1 - i];
				matrix[len - 1 - j][len - 1 - i] = temp;
			}
		}
		int i = 0, j = len - 1;
		while (i < j) {
			for (int k = 0; k < len; k++) {
				int temp = matrix[i][k];
				matrix[i][k] = matrix[j][k];
				matrix[j][k] = temp;
			}
			i++;
			j--;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
