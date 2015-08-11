package string;
/**
 *
I 1
V 5
X 10
L 50
C 100
D 500
M 1000
 */
import java.util.HashMap;

public class RomantoInteger {

	/**
	 * @param args
	 */
	private int map(char c) {
		switch (c) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		default:
			return 0;
		}
	}

	public int romanToInt(String s) {
		int result = 0;
		for (int i = 0; i < s.length(); i++) {
			if (i > 0 && map(s.charAt(i)) > map(s.charAt(i - 1))) {
				result += (map(s.charAt(i)) - 2 * map(s.charAt(i - 1)));
			} else {
				result += map(s.charAt(i));
			}
		}
		return result;
	}
	
	public int romanToInt2(String s) {
		HashMap<Character,Integer> maps = new HashMap<Character,Integer>(){
			{
				put('I',1); put('V',5); put('X',10); put('L',50);
				put('C',100); put('D',500); put('M',1000);
			}
		};
		int pre = 0, total = 0;
		for (char c : s.toCharArray()){
			int cur = maps.get(c);
			total += cur > pre ? (cur - 2 * pre) : cur;
			pre = cur;
		}
		return total;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
