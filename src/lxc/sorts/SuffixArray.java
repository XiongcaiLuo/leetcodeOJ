package lxc.sorts;

import java.util.Arrays;

/**
 * suffix array, using Suffix class.
 * @author luoxiongcai
 *
 */
public class SuffixArray {
	private Suffix[] array;
	
	public SuffixArray(String s){
		int len = s.length();
		if (s == null || s.length() == 0) return ;
		array = new Suffix[s.length()];
		for (int i = 0; i < len; i++){
			array[i] = new Suffix(s, i);
		}
		Arrays.sort(array);
	}
	
	public int index(int i){
		return array[i].start;
	}
	
	// longest common prefix of array[i] and array[i-1];
	public int lcp(int i){
		return lcp(i, i-1);
	}
	private int lcp(int i, int j){
		int minLen = Math.min(array[i].length(), array[j].length());
		for (int k = 0; k < minLen; k++){
			if (array[i].charAt(k) != array[j].charAt(k))
				return k;
		}
		return minLen;
	}
	
	private static class Suffix implements Comparable<Suffix>{
		private final String s;
		private final int start;
		public Suffix(String s, int start){
			this.s = s;
			this.start = start;
		}
		private int charAt(int i){
			return s.charAt(start + i);
		}
		private int length(){
			return s.length() - start;

		}
		
		public int compareTo(Suffix other){
			int minLen = Math.min(other.length(), this.length());
			for (int i = 0; i < minLen; i++){
				if (charAt(i) < other.charAt(i)) return -1;
				else if (charAt(i) > other.charAt(i)) return 1;				
			}
			return this.length() < other.length() ? -1 : 1;
		}
		public String toString(){
			return s.substring(start);
		}
	}
	public static void main(String[] args) {
		LongestCommonSubstring lcs= new LongestCommonSubstring();
		String s = "helloworld";
		String t = "yellowaa";
		String lrs = lcs.commonSub(s, t);
		System.out.println(lrs);
	}

}
