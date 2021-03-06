package string;

/**
 * Implement atoi to convert a string to an integer. The atoi function first
 * discards as many whitespace characters as necessary until the first
 * non-whitespace character is found. Then, starting from this character, takes
 * an optional initial plus or minus sign followed by as many numerical digits
 * as possible, and interprets them as a numerical value. The string can contain
 * additional characters after those that form the integral number, which are
 * ignored and have no effect on the behavior of this function. If the first
 * sequence of non-whitespace characters in str is not a valid integral number,
 * or if no such sequence exists because either str is empty or it contains only
 * whitespace characters, no conversion is performed. If no valid conversion
 * could be performed, a zero value is returned. If the correct value is out of
 * the range of representable values, the maximum integer value (2147483647) or
 * the minimum integer value (–2147483648) is returned.
 * 
 * @author luoxiongcai
 *
 */
public class StringtoInteger {

	/**
	 * @param args
	 */
	public int atoi(String str) {
		if (str == null || str.length() == 0)
			return 0;
		int num = 0;
		int sign = 1;
		int n = str.length();
		int i = 0;
		while (i < n && str.charAt(i) == ' ')
			i++;
		if (str.charAt(i) == '+')
			i++;
		else if (str.charAt(i) == '-') {
			sign = -1;
			i++;
		}

		while(Character.isDigit(str.charAt(i))){
			if (num > Integer.MAX_VALUE / 10
					|| (num == Integer.MAX_VALUE / 10 && (str.charAt(i) - '0') > Integer.MAX_VALUE % 10))
				return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
			num = num * 10 + str.charAt(i) - '0';
			i++;
		} 
		return num * sign;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
