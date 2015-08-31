package lxc.subsum;
/**
 * max sum of at most k disjoint sub arrays
 * @author luoxiongcai
 *
 */
public class MaxAtMostKSubArray {
	/**
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */
	public int maxAtMostKSubSum(int[] nums, int k){
		int n =  nums.length;
		if (k > n/2){
			return maxNoLimit( nums);
		}
		int[] sum = new int[n+1];
		int[] preMax = new int[n+1];
		int max = 0;
		for (int i = 1; i <= k; i++){
			int[] curMax = new int[n+1];
			for( int j = i; j <=n ; j++){
				sum[j] = Math.max(sum[j-1], preMax[j-1])+nums[j-1] ;
				curMax[j] = Math.max(sum[j],curMax[j-1]);
			}
			preMax = curMax;
			max = Math.max(max,preMax[n]);
		}
		return max;
	}
	

	
	
	
	private int maxNoLimit(int[] nums) {
		int sum = 0;
		for (int n: nums){
			if ( n > 0)
				sum += n;
		}
		return sum;
	}





	public static void main(String[] args) {
		MaxAtMostKSubArray mk = new MaxAtMostKSubArray();
		int[] nums = {  -2, -3, 7, -6, 4, -5};
		int k = 10;
		int max = mk.maxAtMostKSubSum(nums, k);
		System.out.println(max);

	}

}
