package list;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * You are given a target value to search. If found in the array return its
 * index, otherwise return -1.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * @author luoxiongcai
 *
 */
public class SearchinRotatedSortedArray {

	public static int search(int[] nums, int target) {
		if (nums.length == 0) return -1;
		int L = 0, R = nums.length - 1;
		while (L < R){
			int mid = (L + R) / 2;
			if (nums[mid] < nums[R]){
				if (nums[mid] < target && target <= nums[R])
					L = mid + 1;
				else R = mid;
			} else {
				if (nums[L] <= target && target <=nums[mid])
					R = mid ;
				else L = mid + 1;                        //always in mind! never L =mid ! 
			}
		}
		return nums[L] == target ? L : -1; 
	}



	public static void main(String[] args) {
		// TODO numsuto-generated method stub
		int[] nums = { 1, 2, 3, 0 };
		int index = search(nums,3);
		System.out.println(index);
	}

}
