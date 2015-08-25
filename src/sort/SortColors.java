package sort;

/**
 * Given an array with n objects colored red, white or blue, sort them so that
 * objects of the same color are adjacent, with the colors in the order red,
 * white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white,
 * and blue respectively.
 * 
 * Note: You are not suppose to use the library's sort function for this
 * problem.
 * 
 * click to show follow up.
 * 
 * Follow up: A rather straight forward solution is a two-pass algorithm using
 * counting sort. First, iterate the array counting number of 0's, 1's, and 2's,
 * then overwrite array with total number of 0's, then 1's and followed by 2's.
 * 
 * Could you come up with an one-pass algorithm using only constant space?
 * 
 * @param args
 */
public class SortColors {

	/**
	 * two pass : count sort.
	 * @param A
	 */
	public void sortColors(int[] A) {
		int[] counts = { 0, 0, 0 };
		for (int i = 0; i < A.length; i++)
			counts[A[i]]++;
		for (int i = 0, index = 0; i < 3; i++) {
			for (int j = 0; j < counts[i]; j++)
				A[index++] = i;
		}
	}
	/**
	 * advanced quick sort. partion key is 1
	 * @param A
	 */
	public void sortColors2(int[] A) {
		if (A.length < 2) return ;
		int i = -1, j = A.length, k = 0;
		while (k < j){
			if (A[k] == 2){
				swap(A,k, --j);
			} else if (A[k] == 0){
				swap(A, k++, ++i);
			} else k++;
		}
	}
	
	private void swap (int [] A, int i, int j){
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
