package search;

/**
 * Given a sorted array of integers, find the starting and ending position of a
 * given target value.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * If the target is not found in the array, return [-1, -1].
 * 
 * For example, Given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4]
 * 
 * @param args
 */
public class SearchforaRange {

	public int[] searchRange(int[] A, int target) {
		int min = searchMinIndex(A, target, 0, A.length - 1);
		int max = searchMaxIndex(A, target, 0, A.length - 1);
		return new int[] { min, max };
	}

	private int searchMaxIndex(int[] A, int target, int begin, int end) {
		if (begin > end) return -1;
		int left = begin, right = end;
		int index = -1;
		while (left < right){
			int mid = (left + right) / 2;
			if (A[mid] == target){
				index = mid;
				left = mid + 1;
			} else if (A[mid] < target){
				left = mid + 1;
			} else right = mid - 1;
		}
		return A[left] == target ? left : index;
	}

	private int searchMinIndex(int[] A, int target, int begin, int end) {
		if (begin > end) return -1;
		int left = begin, right = end;
		while (left < right){
			int mid = (left + right) / 2;
			if (A[mid] < target){
				left = mid + 1;
			} else right = mid;
		}
		return A[left] == target ? left : -1;
	}

	public static void main(String[] args) {
		int[] A = new int[] { 1, 2, 2 };
		int target = 2;
		SearchforaRange t = new SearchforaRange();
		int[] bound = t.searchRange(A, target);
		System.out.println(bound[0] + "\t" + bound[1]);
	}

}
