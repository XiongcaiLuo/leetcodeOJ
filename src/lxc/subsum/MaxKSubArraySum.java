package lxc.subsum;

import java.util.Arrays;

/**
 * max sum of k disjoint sub arrays
 * 
 * @author luoxiongcai
 *
 */
public class MaxKSubArraySum {

	/**
	 * DP.
	 * 
	 * @param nums
	 * @param k
	 * @return : max sum of k disjoint sub arrays.
	 */
	public int maxKSubSum(int[] nums, int k) {
		int n = nums.length;
		if (k > n)
			return 0;
		int[][] sum = new int[k + 1][n + 1];
		for (int i = 1; i <= k; i++) {
			for (int j = i; j <= n; j++) {
				sum[i][j] = sum[i][j - 1] + nums[j - 1];
				for (int m = i - 1; m < j; m++) {
					sum[i][j] = Math.max(sum[i][j], sum[i - 1][m] + nums[j - 1]);
				}
			}
		}
		// postprocess
		int max = Integer.MIN_VALUE;
		for (int i = k; i <= n; i++)
			max = Math.max(max, sum[k][i]);
		return max;
	}

	/**
	 * to save time and space.
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */
	public int maxKSubSum2(int[] nums, int k){
		int n =  nums.length;
		if (k > n) return 0;
		int[] sum = new int[n+1];
		int[] preMax = new int[n+1];
		for (int i = 1; i <= k; i++){
			int[] curMax = new int[n+1];
			Arrays.fill(curMax, Integer.MIN_VALUE);
			for( int j = i; j <=n ; j++){
				sum[j] = Math.max(sum[j-1], preMax[j-1])+nums[j-1] ;
				curMax[j] = Math.max(sum[j],curMax[j-1]);
			}
			preMax = curMax;
		}
		return preMax[n];
	}

	public static void main(String[] args) {
		MaxKSubArraySum mk = new MaxKSubArraySum();
		int[] nums = { -2, -3, 7, -6, 4, -5 };
		int k = 3;
		int max = mk.maxKSubSum2(nums, k);
		System.out.println(max);
	}

}
