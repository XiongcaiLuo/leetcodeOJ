package numbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Numbers can be regarded as product of its factors. For example, Each
 * combination’s factors must be sorted ascending, for example: The factors of 2
 * and 6 is [2, 6], not [6, 2].
 * 
 * You may assume that n is always positive.
 * 
 * Factors should be greater than 1 and less than n.
 * 
 * @author luoxiongcai
 *
 */
public class FactorCombinations {
	public List<List<Integer>> getFactors(int n) {
	    List<List<Integer>> result = new ArrayList<List<Integer>>();
	    helper(result, new ArrayList<Integer>(), n, 2);
	    return result;
	}

	public void helper(List<List<Integer>> result, List<Integer> item, int n, int start){
	    if (n <= 1) {
	        if (item.size() > 1) {
	            result.add(new ArrayList<Integer>(item));
	        }
	        return;
	    }

	    for (int i = start; i <= n; ++i) {
	        if (n % i == 0) {
	            item.add(i);
	            helper(result, item, n/i, i);
	            item.remove(item.size()-1);
	        }
	    }
	}
	public static void main(String[] args){
		FactorCombinations fc = new FactorCombinations();
		int n = 12;
		List<List<Integer>> result = fc.getFactors(n);
		System.out.println(result);
	}

}
