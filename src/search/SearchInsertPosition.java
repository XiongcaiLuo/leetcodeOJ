package search;
/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.
if there are duplicates in the array, insert in front of the duplicates.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
 * @author luoxiongcai
 *
 */
public class SearchInsertPosition {

	/**
	 * if duplicate, insert into the first appearence;
	 * @param A
	 * @param target
	 * @return
	 */
	public int searchInsert(int[] A, int target) {
		if(A.length == 0)
			return 0;
		int left = 0, right = A.length - 1;
		while(left < right){
			int mid = (left + right) / 2;
			if(A[mid] < target)
				left = mid + 1;
			else right = mid;
		}
		return A[left] >= target ? left : left + 1;
	}
	/**
	 * if duplicate, insert after the last appearence;
	 * @param A
	 * @param target
	 * @return
	 */
	public int searchInsert2(int[] A, int target) {
		if(A.length == 0)
			return 0;
		int left = 0, right = A.length - 1;
		while(left < right){
			int mid = (left + right) / 2;
			if(A[mid] > target)
				right = mid - 1;
			else left = mid + 1;
		}
		return A[left] <= target ? left + 1 : left;
	}
	public static void main(String[] args) {
		SearchInsertPosition sp = new SearchInsertPosition();
		int [] A = {1,3,5,5,5,6};
		int target = 5;
		int index = sp.searchInsert(A, target);
		int index2 = sp.searchInsert2(A, target);
		System.out.println(index+"\t"+index2);
	}

}
