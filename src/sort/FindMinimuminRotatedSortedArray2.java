package sort;

import search.FindMinimuminRotatedSortedArray;

/**
 * Follow up for "Find Minimum in Rotated Sorted Array": What if duplicates are
 * allowed?
 * 
 * Would this affect the run-time complexity? How and why? Suppose a sorted
 * array is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * Find the minimum element.
 * 
 * The array may contain duplicates.
 * 
 * @author luoxiongcai
 *
 */
public class FindMinimuminRotatedSortedArray2 {
    public int findMin(int[] nums) {
        int L = 0, R = nums.length - 1;
        while (L < R && nums[L] >= nums[R]){
        	int mid = (L + R) / 2;
        	if (nums[mid] < nums[R]){
        		R = mid;
        	} else if (nums[mid] > nums[R]){
        		L = mid + 1;
        	} else R--;   // nums[L] = nums[R] = nums[mid];
        }
        return nums[L];
    }
	public static void main(String[] args) {
		FindMinimuminRotatedSortedArray2 fr = new FindMinimuminRotatedSortedArray2();
		int[] num = {6,7,0,1,1,1,2,4,5};
		int min = fr.findMin(num);
		System.out.println(min);
	}

}
