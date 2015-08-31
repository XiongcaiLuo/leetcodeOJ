package dp;

import java.util.Set;

/**
 * Given a string s and a dictionary of words wordDict, determine if s can be
 * segmented into a space-separated sequence of one or more dictionary words.
 * 
 * For example, given s = "leetcode", wordDict = ["leet", "code"].
 * 
 * Return true because "leetcode" can be segmented as "leet code".
 * 
 * @param args
 */
public class WordBreak {

	public boolean wordBreak(String s, Set<String> wordDict) {
		int n = s.length();
		boolean[] f = new boolean[n+1];
		f[0] = true;
		for (int i = 1; i <=n; i++){
			for (int k = 0; k <= i-1; k++){
				if (f[k] && wordDict.contains(s.substring(k,i))){
					f[i] = true;
					break;
				}
			}
		}
		return f[n];
	}

	public static void main(String[] args) {

	}

}
