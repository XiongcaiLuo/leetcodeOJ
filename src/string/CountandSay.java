package string;

/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 
 * 1 is read off as "one 1" or 11. 11 is read off as "two 1s" or 21. 21 is read
 * off as "one 2, then one 1" or 1211. Given an integer n, generate the nth
 * sequence.
 * 
 * Note: The sequence of integers will be represented as a string.
 * 
 * @param args
 */
public class CountandSay {

	public String countAndSay(int n) {
		if ( n == 1) return "1";
		String s = "1";
		while ( --n > 0){
			s = getNext(s);
		}
		return s;
	}

	private String getNext(String s){
		int i = 0;
		StringBuilder sb = new StringBuilder();
		while (i < s.length()){
			int count = 0;
			char cur = s.charAt(i);
			while (i < s.length() && cur == s.charAt(i) ){
				i++;
				count++;
			}
			sb.append(count+""+cur);
		}
		return sb.toString();
	}

	public static void main(String[] args) {

	}

}
