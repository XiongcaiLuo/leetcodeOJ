package list;

/**
 * Given a non-negative number represented as an array of digits, plus one to
 * the number.
 * 
 * The digits are stored such that the most significant digit is at the head of
 * the list.
 * may change the digits array.
 * @param args
 */
public class PlusOne {

	public static int[] plusOne(int[] digits) {
		for (int i = digits.length - 1; i >= 0; i--) {
			if (digits[i] == 9)
				digits[i] = 0;
			else {
				digits[i] += 1;
				return digits;
			}
		}
		int[] newResult = new int[digits.length + 1];
		newResult[0] = 1;
		return newResult;
	}

	public static void print(int[] digits) {
		for (int i = 0; i < digits.length; i++) {
			System.out.print(digits[i]);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] digits = { 9, 9, 9, 9 };
		print(plusOne(digits));
		System.out.println();
	}

}
