package string;

/**
 * Given a non-negative integer num, repeatedly add all its digits until the
 * result has only one digit.
 * 
 * For example:
 * 
 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only
 * one digit, return it.
 * 
 * Follow up: Could you do it without any loop/recursion in O(1) runtime?
 * 
 * Hint:
 * 
 * A naive implementation of the above process is trivial. Could you come up
 * with other methods? What are all the possible results? How do they occur,
 * periodically or randomly?
 * 
 * @author luoxiongcai
 *
 */
public class AddDigits {
	/**
	 * recursion.
	 * @param num
	 * @return
	 */
    public int addDigits(int num) {
        if ( num < 10) return num;
        while ( (num = getNext(num)) >= 10);
        return num;
    }
    
    private int getNext(int num){
    	if (num < 10) return num;
    	int sum = 0;
    	while ( num > 0){
    		sum += num % 10;
    		num /= 10;
    	}
    	return sum;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
