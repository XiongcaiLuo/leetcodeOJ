package others;

import java.util.ArrayList;
import java.util.List;

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
}

/**
 * Given a set of non-overlapping intervals, insert a new interval into the
 * intervals (merge if necessary).
 * 
 * You may assume that the intervals were initially sorted according to their
 * start times.
 * 
 * Example 1: Given intervals [1,3],[6,9], insert and merge [2,5] in as
 * [1,5],[6,9].
 * 
 * Example 2: Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in
 * as [1,2],[3,10],[12,16].
 * 
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 * 
 * @param args
 */
public class InsertInterval {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval){
		List<Interval> result = new ArrayList<Interval>();
		int min = -1, max = -1;
		int i = 0,j = intervals.size() - 1;
		for (; i < intervals.size() && intervals.get(i).start <= newInterval.end; i++){
			if (isCross(intervals.get(i),newInterval)){
				min = i;
				break;
			}
		}
		for (; j >=Math.max(min,0) && intervals.get(j).end >= newInterval.start ; j--){
			if (isCross(intervals.get(j),newInterval)){
				max = j;
				break;
			}
		}
		if (min == -1){
			result.addAll(intervals.subList(0, i));
			result.add(newInterval);
			result.addAll(intervals.subList(i,intervals.size()));
			return result;
		} else {
			newInterval.start = Math.min(newInterval.start, intervals.get(min).start);
			newInterval.end = Math.max(newInterval.end, intervals.get(max).end);
			result.addAll(intervals.subList(0, min));
			result.add(newInterval);
			result.addAll(intervals.subList(max+1, intervals.size()));
			return result;
		}
	}


	private boolean isCross(Interval f1, Interval f2){
		if (f1.start <= f2.start){
			return f1.end >= f2.start;
		} else return f2.end >= f1.start;
	}
	
	/**
	 * 
	 * @param intervals
	 * @param newInterval
	 * @return
	 */
	public List<Interval> insert2(List<Interval> intervals, Interval newInterval){
		List<Interval> result = new ArrayList<Interval>();
		for (int i = 0; i < intervals.size(); i++){
			if (intervals.get(i).start > newInterval.end){
				result.add(newInterval);
				result.addAll(intervals.subList(i, intervals.size()));
				return result;
			} else if (intervals.get(i).end < newInterval.start)
				result.add(intervals.get(i));
			else{
				newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
				newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
			}
		}
		result.add(newInterval);
		return result;
	}


	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(1, 5));
		InsertInterval t = new InsertInterval();
		t.insert(intervals, new Interval(2, 3));
	}

}
