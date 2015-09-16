package bit;

/**
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND
 * of all numbers in this range, inclusive.
 * 
 * For example, given the range [5, 7], you should return 4.
 * 
 * @author luoxiongcai
 *
 */
public class BitwiseANDofNumbersRange {
    public int rangeBitwiseAnd(int m, int n) {
        int result = 0;
        int count = n - m + 1;
        for (int i = 0; i < 32; i++){
            if (count <= ( 1 << i) &&  isOne(m,i) & isOne(n, i)){
                result |= (1 << i);
            }
        }
        return result;
    }
    private boolean isOne(int m, int i){
       return ((m >> i) & 1) == 1;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
