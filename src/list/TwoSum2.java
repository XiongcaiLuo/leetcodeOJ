package list;
/**
 * just like twosum. but input array is sorted. index is 1-based.
 * @author luoxiongcai
 *
 */
public class TwoSum2 {
	public int[] twoSum(int[] nums, int target){
		// assert nums.length >=2
		int i=0, j = nums.length -1;
		while( i <j){
			if(nums[i] + nums[j] == target){
				return new int[]{i+1,j+1};
			} else if(nums[i] + nums[j] < target){
				i++;
			} else j--;
		}
		return new int[]{0,0};
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
