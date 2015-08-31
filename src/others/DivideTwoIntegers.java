package others;

/**
 * Divide two integers without using multiplication, division and mod operator.
 * 
 * If it is overflow, return MAX_INT
 * 
 * @param args
 */
public class DivideTwoIntegers {

	public int divide(int dividend, int divisor) {
		if (dividend == Integer.MIN_VALUE && divisor == -1)
			return Integer.MAX_VALUE;
		boolean isNeg = ((dividend ^ divisor) >>> 31 == 1) ? true : false;
		long result = 0;
		long a = dividend, b  = divisor;
		a =  a < 0 ? -a : a;
		b =  b < 0 ? -b : b;
		while (a >= b){
			long c = b;
			for (int i = 0; c <=a ; c <<= 1, i++){
				a -= c ;
				result += 1 << i;
			}
		}
		return (int) (isNeg ? -result : result);
	}

	public static void main(String[] args) {
		DivideTwoIntegers t = new DivideTwoIntegers();
		int a = 1, b = 2;
		int c = t.divide(a, b);

		System.out.println(c);
	}

}
