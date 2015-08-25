package search;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * Find the minimum element.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * @author luoxiongcai
 *
 */

public class FindMinimuminRotatedSortedArray {
	/**
	 * 利用二分搜索最小值，最大值，特定值，插入位置。 有重复，没重复。
	 * @param nums
	 * @return
	 */
	public int findMin(int[] nums) {
		int L = 0, R = nums.length - 1;
		while (L < R && nums[L] >= nums[R]){
			int mid = (L + R) / 2;
			if (nums[mid] < nums[R])
				R = mid;
			else L = mid + 1;
		}
		return nums[L];
	}
	
	
	public static void main(String [] args){
		FindMinimuminRotatedSortedArray fr = new FindMinimuminRotatedSortedArray();
		int[] nums = {6,7,0,1,2,4,5};
		int min = fr.findMin(nums);
		System.out.println(min);
	}
}
