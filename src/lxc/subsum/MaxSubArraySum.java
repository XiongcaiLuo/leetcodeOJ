package lxc.subsum;
/**
 * max subarray sum.
 * @author luoxiongcai
 *
 */
public class MaxSubArraySum {

	/**
	 * dp.
	 * when the max is negative, return the sum, not 0;
	 * @param nums
	 * @return
	 */
	public int maxSubSum(int[] nums){
		if (nums == null) return 0 ;
		int max = nums[0];
		int curMax = nums[0];
		for (int i = 1; i < nums.length; i++){
			curMax = Math.max(nums[i], nums[i]+curMax);
			max = Math.max(max, curMax);
		}
		return max;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
