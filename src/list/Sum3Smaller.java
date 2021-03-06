package list;
/**
 * Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.

For example, given nums = [-2, 0, 1, 3], and target = 2.

Return 2. Because there are two triplets which sums are less than 2:

[-2, 0, 1]
[-2, 0, 3]
 * @author luoxiongcai
 *
 */
public class Sum3Smaller {
	public int threeSumSmaller(int[] nums, int target){
		if (nums.length < 3) return 0;
		int result = 0;
		for (int i = 0; i < nums.length - 2; i++){
			int j = i + 1; int k = nums.length - 1;
			while ( j < k ){
				if (nums[i] + nums[j] + nums[k] >= target){
					k--;
				} else {
					result += (k - j);
					j++;
				}
			}
		}
		return result;
	}
	public static void main(String[] args) {
		Sum3Smaller ss = new Sum3Smaller();
		int[] nums = {-2, 0, 1, 3};
		int target = 2;
		int re = ss.threeSumSmaller(nums, target);
		System.out.println(re);
	}

}
