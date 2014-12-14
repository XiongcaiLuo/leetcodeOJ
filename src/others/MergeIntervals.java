package others;

import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {

	/**
	 * Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
	 * @param args
	 */
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    	if(intervals.isEmpty() ){
    		intervals.add(newInterval);
    		return intervals;
    	}
    	List<Interval> result=new LinkedList<Interval>();
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
    public List<Interval> merge(List<Interval> intervals) {
        int size=intervals.size();
        if(size==1) return intervals;
        List<Interval> result=new LinkedList<Interval>();
        for(int i=1;i<size;i++){
        	result=insert(result,intervals.get(i));
        }
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}