package list;
/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 * @author luoxiongcai
 *
 */
public class ZigZagConversion {

    public  String convert(String s, int nRows) {
    	if (s.length() == 0 || nRows <=1) return s;
    	boolean flag = true;
    	int state = 0;
    	StringBuilder[] sbs = new StringBuilder[nRows];
    	for (int i = 0; i < nRows; i++)
    		sbs[i] = new StringBuilder();
    	for (int i = 0; i < s.length(); i++){
    		sbs[state].append(s.charAt(i));
    		if ((state == nRows - 1 && flag) || (state == 0 && !flag))
    			flag = !flag;
    		state = getNext(state,flag);
    	}
    	for (int i =1; i < nRows; i++){
    		sbs[0].append(sbs[i]);
    	}
    	return sbs[0].toString();
    }
    
    private int getNext(int state, boolean flag){
    	return flag ? state +1 : state - 1;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ZigZagConversion zz = new ZigZagConversion();
		String s="ABCD";
		System.out.println(zz.convert(s,2));

	}

}
