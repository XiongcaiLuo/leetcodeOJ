package string;

/**
 * Given a string S, find the length of the longest substring T that contains at
 * most two distinct characters. For example, Given S = “eceba”, T is "ece"
 * which its length is 3.
 * 
 * @author luoxiongcai
 *
 */
public class LongestSubstringKMostDistinctCharacters {

	public int lengthOfLongestSubstringTwoDistinct(String s){
		if(s.length() < 3)
			return s.length();
		return lengthOfLongestSubstringKDistinct(s, 2);
	}
	
	public int lengthOfLongestSubstringKDistinct(String s, int k){
		int[] count = new int [256];
		int uniqueNum = 0;
		int max = 0;
		for(int i = 0, j = 0; i < s.length(); i++){
			if (count[s.charAt(i)]++ == 0)
				uniqueNum++;
			while (uniqueNum > k){
				if ( --count[s.charAt(j++)] == 0)
					uniqueNum--;
			}
			max = Math.max(max, i - j + 1);
		}
		return max;
	}
	
	public static void main(String[] args) {
		LongestSubstringKMostDistinctCharacters dc = new LongestSubstringKMostDistinctCharacters();
		String s = "abaadgjwpetgsgslgc";
		int len = dc.lengthOfLongestSubstringKDistinct(s,4);
		System.out.println(len);
	}

}
