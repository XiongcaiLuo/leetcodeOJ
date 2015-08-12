package list;

/**
 * Follow up for ”Remove Duplicates”: What if duplicates are allowed at most
 * twice? For example, Given sorted array A = [1,1,1,2,2,3], Your function
 * should return length = 5, and A is now [1,1,2,2,3]
 * 
 * @author luoxiongcai
 *
 */
public class RemoveDuplicatesfromSortedArray2 {

	public int removeDuplicates(int[] A) {
		int size = A.length;
		if (size <= 2)
			return size;
		int index = 1;
		for (int i = 2; i < size; i++) {
			if (A[i] != A[index - 1]) {  // here ! 
				A[++index] = A[i];
			}
		}
		return index + 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveDuplicatesfromSortedArray2 t = new RemoveDuplicatesfromSortedArray2();
		int[] A = { 1, 1, 2, 2, 2, 3 };
		for (int a : A)
			System.out.print(a + "\t");
		System.out.println();
		System.out.println(t.removeDuplicates(A));
	}

}
