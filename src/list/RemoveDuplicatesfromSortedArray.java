package list;

/**
 * Given a sorted array, remove the duplicates in place such that each element
 * appear only once and return the new length. Do not allocate extra space for
 * another array, you must do this in place with constant memory. For example,
 * Given input array A = [1,1,2], Your function should return length = 2, and A
 * is now [1,2].
 * 
 * @author luoxiongcai
 *
 */
public class RemoveDuplicatesfromSortedArray {

	public int removeDuplicates(int[] A) {
		int size = A.length;
		if (size == 0 )
			return 0;
		int index = 0;
		for (int i = 1; i < A.length; i++){
			if (A[i] != A[index])
				A[++index] = A[i]; 
		}
		return index + 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveDuplicatesfromSortedArray t = new RemoveDuplicatesfromSortedArray();
		int[] A = { 1, 1, 2 };
		System.out.println(t.removeDuplicates(A));
	}

}
