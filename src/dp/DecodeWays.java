package dp;

public class DecodeWays {

	/**
	 * A message containing letters from A-Z is being encoded to numbers using
	 * the following mapping:
	 * 
	 * 'A' -> 1 'B' -> 2 ... 'Z' -> 26 Given an encoded message containing
	 * digits, determine the total number of ways to decode it.
	 * 
	 * For example, Given encoded message "12", it could be decoded as "AB" (1
	 * 2) or "L" (12).
	 * 
	 * The number of ways decoding "12" is 2.
	 * 
	 * @param args
	 */

	/**
	 * 
	 * @param s
	 * @return
	 */
	// public int numDecodings(String s) {
	// if (s.length()==0 || s.charAt(0) == '0') return 0;
	// int prev = 0;
	// int cur = 1;
	//
	// for (int i = 1; i <= s.length(); ++i) {
	// if (s.charAt(i-1) == '0') cur = 0;
	// if (i < 2 || !(s.charAt(i-2) == '1' || (s.charAt(i-2) == '2' &&
	// s.charAt(i-1) <= '6')))
	// prev = 0;
	// int tmp = cur;
	// cur = prev + cur;
	// prev = tmp;
	// }
	// return cur;
	//
	// }

	/**
	 * my method
	 * 
	 * @param s
	 * @return
	 */
	public int numDecodings(String s) {
		int n = s.length();
		if (n == 0)
			return 0;
		int[] f = new int[n + 1];
		f[0] = 1;
		f[1] = (s.charAt(0) == '0') ? 0 : 1;
		for (int i = 2; i <= n; i++) {
			if (s.charAt(i - 1) == '0') {
				f[i] = (s.charAt(i - 2) == '1' || s.charAt(i - 2) == '2') ? f[i - 2] : 0;
			}  else if (s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6')) {
				f[i] = f[i - 1] + f[i - 2];
			}else f[i] = f[i - 1];
		}
		return f[n];
	}

	public static void main(String[] args) {
		DecodeWays t = new DecodeWays();
		int num = t.numDecodings("10");
		System.out.println(num);
	}

}
