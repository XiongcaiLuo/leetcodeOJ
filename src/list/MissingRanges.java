package list;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array where the range of elements are [0, 99]
 * inclusive, return its missing ranges. For example, given [0, 1, 3, 50, 75],
 * return [“2”, “4->49”, “51->74”, “76->99”] Example Questions Candidate Might
 * Ask: Q: What if the given array is empty? A: Then you should return [“0->99”]
 * as those ranges are missing. Q: What if the given array contains all elements
 * from the ranges? A: Return an empty list, which means no range is missing.
 * 
 * @author luoxiongcai
 *
 */
public class MissingRanges {
	public List<String> findMissingRanges(int[] vals, int start, int end) {
		int pre = start - 1;
		List<String> result = new ArrayList<String>();
		for(int i = 0; i <= vals.length; i++){
			int cur = i == vals.length ? end + 1 : vals[i];
			if ( cur - pre >= 2)
				addRange(result, pre, cur);
			pre = cur;
		}
		return result;
	}
	
	private void addRange(List<String> result, int i, int j){
		if ( i >= j)
			return;
		if (j - i == 2)
			result.add("" + (i + 1));
		else {
			result.add((i + 1) + "->" + ( j - 1));
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
