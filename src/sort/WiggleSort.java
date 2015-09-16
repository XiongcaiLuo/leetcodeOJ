package sort;

/**
 * Write a function to convert the array into alternate increasing decreasing
 * numbers:
 * 
 * a[0] <= a[1] >= a[2] <= a[3] >=...
 * 
 * Note: You should solve it in place and one pass.
 * 
 * @author luoxiongcai
 *
 */
public class WiggleSort {
	public void wiggleSort(int[] nums){
		if (nums == null || nums.length < 2) return;
		int flag = -1;
		for (int i = 0; i < nums.length - 1; i++){
			if ((nums[i] - nums[i+1]) * flag < 0){
				swap(nums, i, i+1);
				
			}
			flag = -flag;
				
		}
	}
	
	private void swap(int[] nums, int i, int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	public static void main(String[] args) {
		WiggleSort ws = new WiggleSort();
		int[] nums = {1,2,3,4,5,6};
		ws.wiggleSort(nums);
		for (int nu :nums) System.out.println(nu);
	}

}
