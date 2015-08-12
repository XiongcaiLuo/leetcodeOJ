package list;

/**
 * Design and implement a TwoSum class. It should support the following operations: add
 and find.
 add(input) – Add the number input to an internal data structure.
 find(value) – Find if there exists any pair of numbers which sum is equal to the value.
 For example,
 add(1); add(3); add(5); find(4) 􀃆 true; find(7) 􀃆 false
 * @author luoxiongcai
 *
 */
import java.util.HashMap;
import java.util.Map.Entry;

public class TwoSum3 {
	private HashMap<Integer, Integer> numCount = new HashMap<Integer, Integer>();

	public void add(int num) {
		int count = numCount.containsKey(num) ? numCount.get(num) + 1 : 1;
		numCount.put(num, count);
	}

	public boolean find(int target) {
		for (Entry<Integer, Integer> first : numCount.entrySet()) {
			Integer count = numCount.get(target - first.getKey());
			if (count != null) {
				if ((first.getValue() * 2 != target) || count > 1)
					return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		TwoSum3 ts = new TwoSum3();
		ts.add(2);
		ts.add(5);
		ts.add(4);
		System.out.println(ts.find(7));
	}

}
