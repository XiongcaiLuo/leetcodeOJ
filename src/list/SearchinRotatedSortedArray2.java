package list;

/**
 * Follow up for "Search in Rotated Sorted Array": What if duplicates are
 * allowed?
 * 
 * Would this affect the run-time complexity? How and why?
 * 
 * Write a function to determine if a given target is in the array.
 * 
 * @author luoxiongcai
 *
 */
public class SearchinRotatedSortedArray2 {
	
    public boolean search(int[] nums, int target) {
        if (nums.length == 0) return false;
        int L = 0, R = nums.length - 1;
        while (L < R){
        	int mid = (L + R) / 2;
        	if (nums[mid] == target)
        		return true;
        	if (nums[mid] < nums[R]){
        		if (nums[mid] < target && target <= nums[R])
        			L = mid + 1;
        		else R = mid;
        	} else if (nums[mid] > nums[R]){
        		if (nums[L] <= target && target <= nums[mid])
        			R = mid;
        		else L = mid + 1;
        	} else R--;
        }
        return nums[L] == target ? true : false;
    }
	public static void main(String[] args) {
		SearchinRotatedSortedArray2 sa2 = new SearchinRotatedSortedArray2();
		int[] nums = {1,3};
		int target = 3;
		boolean flag = sa2.search(nums, target);
		System.out.println(flag);
	}

}
