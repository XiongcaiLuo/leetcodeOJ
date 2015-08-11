package dp;

/**
 * Find the contiguous subarray within an array (containing at least one number)
 * which has the largest product.
 * 
 * For example, given the array [2,3,-2,4], the contiguous subarray [2,3] has
 * the largest product = 6.
 * 计算子序列的时候，不要忘记了一种情况就是只保留它自身。
 * @author luoxiongcai
 *
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int curMin = nums[0], curMax = nums[0], max = nums[0];
        for(int i = 1; i< nums.length; i++){
        	int cMin = curMin, cMax = curMax;          // here be careful!!!
        	curMin = Math.min(nums[i], Math.min(nums[i] * cMin, nums[i] * cMax));
        	curMax = Math.max(nums[i], Math.max(nums[i] * cMin, nums[i] * cMax));
        	max = Math.max(max, curMax);
        }
        return max;
    }
	public static void main(String[] args) {
		MaximumProductSubarray mp = new MaximumProductSubarray();
		int [] nums= {-5,2,4,1,-2,2,-6,3,-1,-1,-1,-2,-3,5,1,-3,-4,2,-4,6,-1,5,-6,1,-1,-1,1,1,-1,1,1,-1,-1};
		int pro = mp.maxProduct(nums);
		System.out.println(pro);
	}

}
