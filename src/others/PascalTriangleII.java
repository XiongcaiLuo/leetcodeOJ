package others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given an index k, return the kth row of the Pascal's triangle.
 * 
 * For example, given k = 3, Return [1,3,3,1].
 * 
 * Note: Could you optimize your algorithm to use only O(k) extra space?
 * 
 * @param args
 */
public class PascalTriangleII {

	public List<Integer> getRow(int rowIndex) {
		ArrayList<Integer> re = new ArrayList<Integer>();
		re.add(1);
		for (int round = 1; round <= rowIndex; round++) {
			for (int i = re.size() -1 ; i >=1 ; i--)
				re.set(i, re.get(i-1)+re.get(i));
			re.add(1);
		}
		return re;
	}

	public static void main(String[] args) {
		PascalTriangleII t = new PascalTriangleII();
		List<Integer> re = t.getRow(0);
		System.out.println(re);
	}

}
