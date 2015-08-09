package list;

/**
 * Reverse digits of an integer. For example: x = 123, return 321. Example
 * Questions Candidate Might Ask: Q: What about negative integers? A: For input
 * x = –123, you should return –321. Q: What if the integer’s last digit is 0?
 * For example, x = 10, 100, … A: Ignore the leading 0 digits of the reversed
 * integer. 10 and 100 are both reversed as 1. Q: What if the reversed integer
 * overflows? For
 * 
 * @author luoxiongcai
 *
 */
public class ReverseInteger {

	/**
	 * @param args
	 */
	public static int reverse(int x) {
		int ret = 0;
		while ( x != 0){
			if ( Math.abs(ret) > 214748364)  // overflow
				return 0;
			ret =  ret * 10 + x % 10;
			x = x / 10;
		}
		return ret;
	}

	public static void main(String[] args) {
		
		System.out.println(reverse(-123));

	}

}
