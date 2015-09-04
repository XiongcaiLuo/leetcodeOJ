package lxc.sorts;


/**
 * longest common substring of two given strings.
 * @author luoxiongcai
 *
 */
public class LongestCommonSubstring {
	/**
	 * use suffix array.
	 * @param s
	 * @param t
	 * @return
	 */
	public String commonSub(String s, String t){
		String st = s + "\0" + t;
		SuffixArray sa = new SuffixArray(st);
		int max = 0;
		String lrs = "";
		for (int i = 1; i < st.length(); i++ ){
			int len = sa.lcp(i);
			if ( len > max){
				max = len;
				lrs = st.substring(sa.index(i), sa.index(i) + len);
			}
		}
		return lrs;
	}
	public static void main(String[] args) {
		LongestCommonSubstring lcs= new LongestCommonSubstring();
		String s = "helloworld";
		String t = "yellowaa";
		String lrs = lcs.commonSub(s, t);
		System.out.println(lrs);
	}

}
