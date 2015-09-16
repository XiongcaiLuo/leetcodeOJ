package algs4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Test {
	public String atMostTwo(String s) { // not null .
		int unique = 0;
		Map<Character, Integer> maps = new HashMap<Character, Integer>();
		int i = 0, j = 0;
		int maxLen = 0;
		int index = 0;
		while (j < s.length()) {
			if (!maps.containsKey(s.charAt(j))) {
				maps.put(s.charAt(j), 1);
				unique++;
			} else {
				maps.put(s.charAt(j), maps.get(s.charAt(j)) + 1);
			}
			while (unique > 2) {
				int curCount = maps.get(s.charAt(i));
				if (curCount == 1) {
					maps.remove(s.charAt(i));
					unique--;
				} else{
					maps.put(s.charAt(i), maps.get(s.charAt(i))-1);
				}
				i++;
			}
			if (j - i + 1 > maxLen) {
				maxLen = j - i + 1;
				index = i;
			}
			j++;
		}
		return s.substring(index, index + maxLen);
	}

	public static void main(String[] args) {
		String token = " hello world  ";
		String[] segs = token.split(" ",0);
		for (int i = 0; i < segs.length; i++){
			System.out.println(i + ":" + segs[i]);
		}
	}

}