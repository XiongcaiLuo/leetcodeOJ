package string;

/**
 * Given an integer, convert it to a roman numeral.
 * 
 * Input is guaranteed to be within the range from 1 to 3999.
 * Roman Literal Decimal
I 1
V 5
X 10
L 50
C 100
D 500
M 1000
 * @author luoxiongcai
 *
 */
public class IntegertoRoman {
    public String intToRoman(int num) {
        int [] radix = {1000, 900, 500, 400, 100, 90 ,50, 40, 10, 9, 5, 4, 1};
        String [] radixStr = {"M", "CM","D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i< radix.length; i++){
        	int ret = num / radix[i];
        	for (int j = 0; j < ret; j++){
        		sb.append(radixStr[i]);
        	}
        	num = num % radix[i];
        }
        return sb.toString();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
