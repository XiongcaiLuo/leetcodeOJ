package others;

import java.util.ArrayList;
import java.util.List;

 class Interval {
   int start;
     int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}

public class InsertInterval {

	/**
	 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:
Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
	 * @param args
	 */
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    	if(intervals.isEmpty() ){
    		intervals.add(newInterval);
    		return intervals;
    	}
    	List<Interval> result=new ArrayList<Interval>();
    	int size=intervals.size();
    	if(intervals.get(0).start>newInterval.end){
    		result.add(newInterval);
    		result.addAll(intervals);
    		return result;
    	}
    	if(intervals.get(size-1).end<newInterval.start){

    		result.addAll(intervals);
    		result.add(newInterval);
    		return result;
    	}
    	
    	int begin=0;
    	while(begin<size && intervals.get(begin).end<newInterval.start)
    		begin++;
    	int end=size-1;
    	while(end>=0 && intervals.get(end).start>newInterval.end)
    		end--;
    	System.out.println(begin+"\t"+end);
    	int min=Math.min(newInterval.start, intervals.get(begin).start);
    	int max=Math.max(newInterval.end, intervals.get(end).end);
    	for(int i=0;i<begin;i++)
    		result.add(intervals.get(i));
    	result.add(new Interval(min,max));
    	for(int i=end+1;i<size;i++)
    		result.add(intervals.get(i));
    	return result;
    		
        	
    }
	public static void main(String[] args) {
		List<Interval> intervals=new ArrayList<Interval>();
		intervals.add(new Interval(1,5));
		InsertInterval t=new InsertInterval();
		t.insert(intervals, new Interval(2,3));
	}

}
