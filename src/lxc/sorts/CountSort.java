package lxc.sorts;
/**
 * count sort for an array of integers.
 * @author luoxiongcai
 *
 */
public class CountSort {
	public static void sort(int[] nums,int min, int max){
		assert max >= min;
		int[] count = new int[max - min + 1];
		for (int num : nums)
			count[num - min]++;
		for (int i = 1; i <= max - min; i++)
			count[i] += count[i-1];
		int[] aux = new int[nums.length];
		for (int i = nums.length - 1; i >= 0 ; i--) // it's stable now.
			aux[--count[ nums[i] - min]] = nums[i];
		System.arraycopy(aux, 0, nums, 0, nums.length);
	}
	

	public static void main(String[] args) {
//		int[] nums = {3,6,1,-3,1,2};
//		int max = 6;
//		int min = -3;
//		sort(nums, min, max);
//		for (int n : nums)
//			System.out.print(n+" ");
		

	}

}
