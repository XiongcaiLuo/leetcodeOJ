package string;

import java.util.HashMap;

/**
 * Implement strStr().
 * 
 * Returns the index of the first occurrence of needle in haystack, or -1 if
 * needle is not part of haystack.
 * 
 * @param args
 */
public class StrStr {

	public int strStr(String haystack, String needle) {
		if (needle.isEmpty())
			return 0;
		else if (haystack.isEmpty())
			return -1;
		
		int[][] DAF = getDAF(needle);
		int n = haystack.length(), m = needle.length();
		for (int i = 0,state = 0; state < m; i++){
			state = DAF[haystack.charAt(i)][state];
			if (state == m)
				return i - m + 1;
		}
		return -1;
	}



	public int[][] getDAF(String needle) {
		int[][]DAF = new int[256][needle.length()];
		char [] cs = needle.toCharArray();
		DAF[cs[0]][0] = 1;
		for (int i = 1, x = 0; i < needle.length(); i++){
			for (int j = 0; j < 256; j++)
				DAF[j][i] = DAF[j][x];
			DAF[cs[i]][i] = i + 1;
			x= DAF[cs[i]][x];
		}
		return DAF;
	}

	public int strStr2(String haystack, String needle) {
		if (needle.isEmpty())
			return 0;
		if (haystack.isEmpty())
			return -1;
		for (int i = 0; i <= haystack.length() - needle.length(); i++) {
			int j = 0;
			for (; j < needle.length(); j++) {
				if (haystack.charAt(i + j) != needle.charAt(j))
					break;
			}
			if (j == needle.length())
				return i;
		}
		return -1;
	}

	public static void main(String[] args) {
		StrStr t = new StrStr();
		int index = t.strStr("mississippi", "issip");
		System.out.println(index);
	}

}
