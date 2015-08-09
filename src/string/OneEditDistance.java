package string;

/**
 * Given two strings S and T, determine if they are both one edit distance
 * apart. Hint: 1. If | n – m | is greater than 1, we know immediately both are
 * not one-edit distance apart. 2. It might help if you consider these cases
 * separately, m == n and m ≠ n. 3. Assume that m is always ≤ n, which greatly
 * simplifies the conditional statements. If m > n, we could just simply swap S
 * and T. 4. If m == n, it becomes finding if there is exactly one modified
 * operation. If m ≠ n, you do not have to consider the delete operation. Just
 * consider the insert operation in T.
 * 
 * @author luoxiongcai
 *
 */
public class OneEditDistance {
	public boolean isOneEditDistance(String s, String t) {
		if (s.length() > t.length())                      // to make sure s.length() <= t.length(); great!
			return isOneEditDistance(t, s);
		if (t.length() - s.length() > 1)
			return false;
		for (int i = 0; i < s.length(); i++){
			if (s.charAt(i) != t.charAt(i))
				return s.substring(i).equals(t.substring(i + 1));
		}
		return true;
	}
	public static void main(String[] args) {
		OneEditDistance oed = new OneEditDistance();
		String s = "agfd";
		String t = "agfde";
		boolean flag = oed.isOneEditDistance(s, t);
		System.out.println(flag);
	}

}
