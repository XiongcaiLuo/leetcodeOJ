package string;

public class IntegertoRoman {

	/**
	 * @param args
	 */
    public String intToRoman(int num) {
        int [] radix = {1000, 900, 500, 400, 100, 90,50, 40, 10, 9, 5, 4, 1};
        String[] symbol={"M", "CM", "D", "CD", "C", "XC","L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder str=new StringBuilder();
        for(int i=0;num>0;i++){
        	int count=num/radix[i];
        	num %=radix[i];
        	for(;count>0;count--)
        		str.append(symbol[i]);
        }
        return str.toString();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
