package dp;

/**
 * Find the contiguous subarray within an array (containing at least one number)
 * which has the largest sum.
 * 
 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4], the contiguous subarray
 * [4,−1,2,1] has the largest sum = 6.
 * 
 * 
 * More practice: If you have figured out the O(n) solution, try coding another
 * solution using the divide and conquer approach, which is more subtle.
 * 
 * @author luoxiongcai
 *
 */
public class MaximumSubarray {
	/**
	 * DP.o(1)time
	 * @param nums
	 * @return
	 */
	public int maxSubnumsrray(int[] nums) {
		int max = nums[0], curMax = nums[0];        // be careful about space;
		for (int i = 1; i < nums.length; i++) {
			curMax = curMax < 0 ? nums[i] : curMax + nums[i];
			max = Math.max(curMax, max);
		}
		return max;
	}
	
	/**
	 * divide and conquer;
	 * @param nums
	 * @return
	 */
	public int maxSubnumsrray2(int[] nums) {  // be careful about negative result;
		if ( nums.length == 0) return 0;
		return maxHelper(nums, 0, nums.length - 1);
	}
	
	private int maxHelper(int[] nums, int left, int right){
		if (left > right) return 0;
		if (left == right) return nums[left];
		int mid = (left + right) / 2;
		int leftMax = maxHelper(nums, left, mid);
		int rightMax = maxHelper(nums, mid + 1, right);
		int curMax = Math.max(leftMax, rightMax);
		int subLeftMax = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = mid; i >=left; i--){
			sum += nums[i];
			subLeftMax = Math.max(subLeftMax, sum);
		}
		int subRightMax = Integer.MIN_VALUE;
		sum = 0;
		for(int i = mid+1; i <= right; i++){
			sum += nums[i];
			subRightMax = Math.max(subRightMax, sum);
		}
		
		return Math.max(curMax,Math.max((subLeftMax > subRightMax ? subLeftMax: subRightMax),subLeftMax + subRightMax));
	}
}
