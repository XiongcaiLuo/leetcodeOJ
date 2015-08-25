package sort;

/**
 * Given an unsorted integer array, find the first missing positive integer.
 * 
 * For example, Given [1,2,0] return 3, and [3,4,-1,1] return 2.
 * 
 * Your algorithm should run in O(n) time and uses constant space.
 * 
 * @param args
 */
public class FirstMissingPositive {

	public int firstMissingPositive(int[] A) {
		if (A == null || A.length < 1)
			return 1;
		for (int i = 0; i < A.length; i++) {
			while (A[i] != i+1){
				if (A[i] <=0 || A[i] >A.length || A[i] == A[A[i] - 1])
					break;
				swap(A, i, A[i] - 1);
			}
		}
		for (int k = 0; k < A.length; k++) {
			if (A[k] != k + 1)
				return k + 1;
		}
		return A.length + 1;
	}

	private void swap(int[] A, int i, int j){
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

	public static void main(String[] args) {
		FirstMissingPositive fp = new FirstMissingPositive();
		int[] A = { 3, 4, -1, 1 };
		int f = fp.firstMissingPositive(A);
		System.out.println(f);
	}

}
