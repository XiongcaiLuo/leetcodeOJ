package list;

/**
 * Given an array of integers, every element appears three times except for one.
 * Find that single one.
 * 
 * Note: Your algorithm should have a linear runtime complexity. Could you
 * implement it without using extra memory?
 * 
 * @author luoxiongcai
 *
 */

public class SingleNumberII {

	/**
	 * 对于k重复数，找其中只出现一次元素，本质上就是要找到一种k元运算符，使得它作用在k个相同的元素上时为0（或者某个部分为0）；且该k元运算符满足交换律。
	 * be careful about the initial zeroBits !!! it's ~0 ,not 0!
	 * @param nums
	 * @return
	 */
    public  int singleNumber(int[] nums) {
        int zeroBits = ~0, oneBits =0, twoBits = 0, temp = 0;
        for (int x : nums){
        	temp = twoBits;
        	twoBits = (twoBits & ~x) | (oneBits & x);
        	oneBits = (oneBits & ~x) | (zeroBits & x);
        	zeroBits = (zeroBits & ~x) | (temp & x);
        }
        return oneBits;
    }
	public static void main(String[] args) {
		SingleNumberII sn = new SingleNumberII();
		int [] nums = {1,1,1,3};
		int single =  sn.singleNumber(nums);
		System.out.println(single);
	}

}
