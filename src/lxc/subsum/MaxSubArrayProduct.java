package lxc.subsum;
/**
 * return the max product of subarray.
 * the element may be <0, 0 , >0;
 * @author luoxiongcai
 *
 */
public class MaxSubArrayProduct {
	public int maxProduct(int[] nums){
		if ( nums.length == 0 ) return 0;
		int min = nums[0], max = nums[0];
		int gmin = min, gmax = max;
		for (int i = 1; i < nums.length; i++){
			int curMin = min, curMax = max;
			min =Math.min(nums[i], Math.min(nums[i]*curMin, nums[i]*curMax));
			max =Math.max(nums[i], Math.min(nums[i]* curMin, nums[i] * curMax));
			gmin = Math.min(gmin,min);
			gmax = Math.max(gmax,max);
		}
		return gmax;
	}
	public static void main(String[] args) {
		MaxSubArrayProduct ma = new MaxSubArrayProduct();
		int[] nums = {1,3,5,-2,1};
		int max = ma.maxProduct(nums);
		System.out.println(max);
	}

}
