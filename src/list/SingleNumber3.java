package list;

/**
 * Given an array of numbers nums, in which exactly two elements appear only
 * once and all the other elements appear exactly twice. Find the two elements
 * that appear only once.
 * 
 * For example:
 * 
 * Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
 * 
 * Note: The order of the result is not important. So in the above example, [5,
 * 3] is also correct. Your algorithm should run in linear runtime complexity.
 * Could you implement it using only constant space complexity?
 * 
 * @author luoxiongcai
 *
 */
public class SingleNumber3 {
	/**
	 * 2n+2变成2n+1的形式。利用异或之后的一个1进行区分即可。 最后一个1 的掩码： n & (~(n-1))
	 * @param nums
	 * @return
	 */
    public int[] singleNumber(int[] nums) {
         int x = 0;
         for (int num : nums)
        	 x ^= num;
         int mask = x & (~(x-1));
         int a = 0, b = 0;
         for (int num : nums){
        	 if ((mask & num )== mask)
        		 a ^= num;
        	 else b ^= num;
         }
         int[] result = {a,b};
         return result;
    }
	public static void main(String[] args) {
		SingleNumber3 sn = new SingleNumber3();
		int[] nums = {1,1,2,2,3,5};
		int[] re = sn.singleNumber(nums);
		System.out.println(re[0]+"\t"+re[1]);
	}
}
