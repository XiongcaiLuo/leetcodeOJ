package string;

public class ValidPalindrome {
/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
method: Character.isLetterOrDigit(char c);
 * @param s
 * @return
 */
    public boolean isPalindrome(String s) {
    	if(s.isEmpty()) return true;
    	int i = 0, j = s.length() - 1;
    	while (i < j){
    		while(i < j && !Character.isLetterOrDigit(s.charAt(i))) i++;
    		while(i < j && !Character.isLetterOrDigit(s.charAt(j))) j--;
    		if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))
    			return false;
    		i++;
    		j--;
    	}
		return true;
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ValidPalindrome t= new ValidPalindrome();
//		String s=" ";
//		System.out.println(t.isPalindrome(s));
		
//		String s="are4 d.H: tt2";
//		String regex="[^\\w]";
//		System.out.println(s.replaceAll(regex, "").toLowerCase());
	}

}
