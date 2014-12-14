package sort;

public class FirstMissingPositive {

	/**
	 * Given an unsorted integer array, find the first missing positive integer.
	 * 
	 * For example, Given [1,2,0] return 3, and [3,4,-1,1] return 2.
	 * 
	 * Your algorithm should run in O(n) time and uses constant space.
	 * 
	 * @param args
	 */
	public int firstMissingPositive(int[] A) {
		if(A==null || A.length<1) return 1;
		int i = 0;
		while (i<A.length) {
			if (A[i] <= 0 || A[i] > A.length || A[i] == A[A[i] - 1])
				break;
			int temp = A[i];
			A[i] = A[A[i] - 1];
			A[A[i] - 1] = temp;
			i++;
		}

		for (int k = 0; k < A.length; k++) {
			if (A[k] != k + 1)
				return k + 1;
		}
		return A.length + 1;
	}

	public static void main(String[] args) {

	}

}
