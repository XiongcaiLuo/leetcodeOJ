package string;

import java.util.Arrays;

/**
Given a binary tree where all the right nodes are either leaf nodes with a sibling 
(a left node that shares the same parent node) or empty, flip it upside down and 
turn it into a tree where the original r ight nodes turned into left leaf nodes. 
Return the new root.
For example:
Given a binary tree {1,2,3,4,5},
    1
   / \
  2   3
 / \
4   5
return the root of the binary tree [4,5,2,#,#,3,1].
   4
  / \
 5   2
    / \
   3   1
 * @author luoxiongcai
 *
 */
public class ValidAnagram {
	/**
	 * use sort
	 * @param s
	 * @param t
	 * @return
	 */
    public boolean isAnagram(String s, String t) {
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        Arrays.sort(cs);
        Arrays.sort(ct);
        return Arrays.equals(cs,ct);
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
