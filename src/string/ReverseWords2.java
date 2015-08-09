package string;

/**
 * just like reversewords, but there are no leading or trailing space.
 * 
 * @author luoxiongcai “The input string does not contain leading or trailing
 *         spaces and the words are always separated by a single space.” Could
 *         you do it in-place without allocating extra space?
 */
public class ReverseWords2 {

	public String ReverseWords(String s) {
		if (s.isEmpty())
			return s;
		char [] chars = s.toCharArray();
		reverse(chars, 0, chars.length - 1);
		for(int i = 0, j = 0;i <= chars.length; i++){
			if (i == chars.length || chars[i] == ' '){
				reverse(chars,j, i - 1);
				j = i + 1;
			}
		}
		return new String(chars);
	}

	private void reverse(char[] chars, int i, int j) {
		while (i < j) {
			char temp = chars[i];
			chars[i] = chars[j];
			chars[j] = temp;
			i++;
			j--;
		}
	}

	public static void main(String[] args) {
		ReverseWords2 rw = new ReverseWords2();
		String s = "hello the word";
		String rs = rw.ReverseWords(s);
		System.out.println(rs);
	}

}
