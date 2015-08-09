package search;
/**
 * implement two binary search algorithms.
 * if target is not in the given array, return -1; otherwise , return the index.
 * @author luoxiongcai
 *
 */
public class BinarySearch {
	public int search(int[] nums, int target){
		if(nums == null || nums.length == 1)
			return -1;
		int left = 0, right = nums.length;
		while(left <= right){
			int mid = (left + right) / 2;
			if(nums[mid] == target)
				return mid;
			else if(nums[mid] > target)
				right = mid - 1;
			else left = mid + 1;
		}
		return -1;
	}
	
	public int search2(int[] nums, int target){
		if(nums == null || nums.length == 1)
			return -1;
		int left = 0, right = nums.length;
		while(left < right){
			int mid = (left + right) / 2;
			if(nums[mid] < target){
				left = mid + 1;
			}else right = mid;
		}
		return nums[right] == target ? right : -1;
	}
	public static void main(String[] args) {
		BinarySearch bs = new BinarySearch();
		int [] nums = {1,3,5,6,7};
		int target = 3;
		int index1 = bs.search(nums, target);
		int index2 = bs.search2(nums, target);
		System.out.println(index1);
		System.out.println(index2);

	}

}
