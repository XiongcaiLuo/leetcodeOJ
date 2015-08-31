package dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, add spaces in s to construct
 * a sentence where each word is a valid dictionary word.
 * 
 * Return all such possible sentences.
 * 
 * For example, given s = "catsanddog", dict = ["cat", "cats", "and", "sand",
 * "dog"].
 * 
 * A solution is ["cats and dog", "cat sand dog"].
 * 
 * @param args
 */
public class WordBreakII {

	List<String> result = new ArrayList<String>();
	Map<Integer,List<Integer>> parents = new HashMap<Integer,List<Integer>>();
	public List<String> wordBreak(String s, Set<String> wordDict) {
		int n = s.length();
		if (n == 0) return result;
		boolean[] f = new boolean[n+1];
		f[0] = true;
		for (int i = 1; i <=n; i++){
			for (int k = 0; k <= i-1; k++){
				if (f[k] && wordDict.contains(s.substring(k,i))){
					f[i] = true;
					List<Integer> parent = parents.containsKey(i) ? parents.get(i) : new ArrayList<Integer>();
					parent.add(k);
					parents.put(i, parent);
					continue;
				}
			}
		}
		if (parents.get(s.length()) == null) return result;
		collect(s, s.length(),new ArrayList<Integer>());
		return result;
	}
	
	private void collect(String s, int cur, List<Integer> path){
		if (cur == 0){
			StringBuilder sb = new StringBuilder();
			sb.append(s.substring(0, path.get(path.size()-1)));
			for (int i = path.size() - 1; i >0; i--){
				sb.append(" "+s.substring(path.get(i), path.get(i-1)));
			}
			result.add(sb.toString());
			return;
		}
		for (int next : parents.get(cur)){
			path.add(cur);
			collect(s,next,path);
			path.remove(path.size() - 1);
		}
	}

	public static void main(String[] args) {
		WordBreakII wb = new WordBreakII();
		String s = "ab";
		Set<String> wordDict = new HashSet<String>(){
			{
				add("a");
				add("b");
			}
		};
		List<String> result = wb.wordBreak(s, wordDict);
		System.out.println(result);
	}

}
