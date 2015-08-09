package string;

/**
 * alidate if a given string is numeric.
 * 
 * Some examples: "0" => true " 0.1 " => true "abc" => false "1 a" => false
 * "2e10" => true Note: It is intended for the problem statement to be
 * ambiguous. You should gather all requirements up front before implementing
 * one.
 * 
 * @author luoxiongcai
 *
 */
public class ValidNumber {

    public boolean isNumber(String s) {
        boolean isNum = false;
        boolean isECorrect = true;
        int i=0;
        while (i < s.length() && s.charAt(i) == ' ') i++;
        if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')) 
        	i++;
        while (i < s.length() && Character.isDigit(s.charAt(i))){
        	isNum = true;
        	i++;
        }
        if(i < s.length() && s.charAt(i) == '.'){
        	i++;
        }
        while (i < s.length() && Character.isDigit(s.charAt(i))){
        	isNum = true;
        	i++;
        }
        if (i < s.length() && s.charAt(i) == 'e' ){
        	i++;
        	isECorrect = false;
        	if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-'))
        		i++;
            while (i < s.length() && Character.isDigit(s.charAt(i))){
            	isECorrect = true;
            	i++;
            }
        }
        //trailing whitespace
        while (i < s.length() && s.charAt(i) == ' ') i++;
        return i == s.length() && isNum && isECorrect;
        	
    }
	public static void main(String[] args) {
		ValidNumber vn = new ValidNumber();
		String s = " e34 ";
		boolean flag = vn.isNumber(s);
		System.out.println(flag);
	}

}
