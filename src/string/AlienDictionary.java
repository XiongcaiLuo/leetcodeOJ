package string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * There is a new alien language which uses the latin alphabet. However, the order among letters are unknown 
 * to you. You receive a list of words from the dictionary, wherewords are sorted lexicographically by the 
 * rules of this new language. Derive the order of letters in this language.

For example,
Given the following words in dictionary,

[
  "wrt",
  "wrf",
  "er",
  "ett",
  "rftt"
]
The correct order is: "wertf".
BE CAREFUL! the word is sorted, not the chars in a word!
 * @author luoxiongcai
 *
 */
public class AlienDictionary {
	Set<Integer> appeared = new HashSet<Integer>();
	List<Integer>[] nodes = (ArrayList<Integer>[])new ArrayList[26];
	public AlienDictionary(){
		for (int i = 0; i < 26; i++)
			nodes[i] = new ArrayList<Integer>();
	}
	private void getGraph(String[] words, int start, int end, int d, int maxLen){
		if (start >= end || d >= maxLen) return;
		int i = start;
		int j = start;
		while (j <= end){
			if (words[j].length() <= d){
				i++;
				j++;
				continue;
			}
			if (words[j].charAt(d) == words[i].charAt(d)){
				j++;
				continue;
			}
			int ci = words[i].charAt(d) - 'a';
			int cj = words[j].charAt(d) - 'a';
			nodes[ci].add(cj);
			getGraph(words, i, j - 1, d + 1, maxLen);
			i = j;
		}
		getGraph(words, i, j - 1, d + 1, maxLen);
	}
	private boolean[] marked = new boolean[26];
	private Stack<Integer> post = new Stack<Integer>();
	private void topologicalSort(){
		for (int i = 0; i < 26; i++){
			if (!marked[i]){
				dfs(i);
			}
		}
	}
	
	private void dfs(int v){
		marked[v] = true;
		for (int w : nodes[v]){
			if (!marked[w])
				dfs(w);
		}
		post.push(v);
	}
	private String getString(){
		StringBuilder result = new StringBuilder();
		while (!post.isEmpty()){
			int v = post.pop();
			if (appeared.contains(v)){
				result.append((char)(v + 'a'));
			}
		}
		return result.toString();
	}
	
	public String alienOrder(String[] words){
		int maxLen = 0;
		for(String w : words){
			maxLen = Math.max(maxLen, w.length());
			for (char c : w.toCharArray())
				appeared.add((int) c - 'a');
		}
		getGraph(words, 0, words.length - 1, 0, maxLen);
		topologicalSort();
		return getString();
	}
	

	public static void main(String[] args) {
		AlienDictionary ad = new AlienDictionary();
		String[] words = {"wrt",
				  "wrf",
				  "er",
				  "ett",
				  "rftt"};
		String re = ad.alienOrder(words);
		System.out.println(re);
	}

}
