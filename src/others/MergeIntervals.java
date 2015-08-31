package others;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * For example, Given [1,3],[2,6],[8,10],[15,18], return [1,6],[8,10],[15,18].
 * 
 * @param args
 */
public class MergeIntervals {

	/**
	 * reuse the InsertInterval.java.
	 * @param intervals
	 * @return
	 */
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<Interval>();
        for (Interval in : intervals)
            result = insert(result, in);
        return result;
    }
    
    public List<Interval> insert(List<Interval> intervals, Interval newInterval){
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
    
    /**
     *  a faster method. o(nlgn);
     * @param intervals
     * @return
     */
    public List<Interval> merge2(List<Interval> intervals) {
        List<Interval> result = new ArrayList<Interval>();
        if (intervals.isEmpty()) return result;
        Collections.sort(intervals, new Comparator<Interval>(){
			@Override
			public int compare(Interval o1, Interval o2) {
				if (o1.start < o2.start) return -1;
				else if (o1.start > o2.start) return 1;
				else return 0;
			}
        });
        result.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++){
        	if (intervals.get(i).start > result.get(result.size()-1).end){
        		result.add(intervals.get(i));
        	} else {
        		Interval in = result.remove(result.size() - 1);
        		in.end = Math.max(intervals.get(i).end, in.end);
        		result.add(in);
        	}
        }
        return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
