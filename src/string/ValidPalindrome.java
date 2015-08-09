package oj.string;

public class ValidPalindrome {
/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
 * @param s
 * @return
 */
    public boolean isPalindrome(String s) {
    	if(s==null||s.isEmpty()) return true;
    	String regex="[^\\w]";
    	String cs=s.replaceAll(regex,"").toLowerCase().trim();
    	if(cs.isEmpty()||cs.length()==1) return true;
    	int ptr1=0,ptr2=cs.length()-1;
    	while(ptr1<ptr2){
    		if(cs.charAt(ptr1)!=cs.charAt(ptr2))
    			return false;
    		ptr1++;
    		ptr2--;

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
