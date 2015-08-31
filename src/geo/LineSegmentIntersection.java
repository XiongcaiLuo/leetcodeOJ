package geo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * Given N horizontal and vertical line segments, find all intersection points.
 * maybe some two lines have the same x coordinate or y coordiate, but not both.
 * @author luoxiongcai
 *
 */
class Point implements Comparable<Point>{
	int flag; // 0: horizontal left, 1: horizontal right; 2: vertial.
	int x,y;
	int y2;
	public Point(int flag, int x, int y){
		this.flag = flag;
		this.x = x;
		this.y = y;
	}
	public Point(int flag,int x, int y1, int y2){
		this.flag = flag;
		this.x = x;
		this.y = y1;
		this.y2 = y2;
	}
	@Override
	public int compareTo(Point o) {
		if (this.x < o.x) return -1;
		else if (this.x > o.x) return 1;
		else return 0;
	}
	
	
}
public class LineSegmentIntersection {
	/**
	 * if want to remove duplicates, then use set<List<Integer>>;
	 * the most difficult situation is [0,1,1] [0,2,1]. two horizontal lines have the same y. 
	 * use a counter!  to count how many lines have the given y.
	 * @param horizontals
	 * @param verticals
	 * @return
	 */
	public List<List<Integer>> intersections(int[][] horizontals, int[][] verticals){
		List<Point> points = new ArrayList<Point>();
		for (int [] h: horizontals){
			points.add(new Point(0, h[0],h[2]));
			points.add(new Point(1, h[1], h[2]));
		}
		for (int[] v: verticals){
			points.add(new Point(3,v[0],v[1],v[2]));
		}
		Collections.sort(points);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		TreeMap<Integer,Integer> heights = new TreeMap<Integer,Integer>(); // key is y, value is a counter.;
		for (Point p : points){
			if (p.flag == 0)
				heights.put(p.y, heights.containsKey(p.y) ? heights.get(p.y)+1 : 1);
			else if (p.flag == 1){
				Integer count = heights.get(p.y);
				if (count == 1)
					heights.remove(p.y);
				else heights.put(p.y, count - 1);
			} 
			else {
				Map<Integer,Integer> intersects = heights.subMap(p.y, true, p.y2, true);
				for (Entry<Integer,Integer> entry: intersects.entrySet()){
					for (int i = 0; i < entry.getValue(); i++){ // if wants no duplicates, just collect once.
						List<Integer> re = new ArrayList<Integer>();
						re.add(p.x); re.add(entry.getKey());
						result.add(re);
					}
				}
			}
		}
		return result;
	}
	public static void main(String[] args) {
		LineSegmentIntersection si = new LineSegmentIntersection();
		int[][] horizontals = {{0,5,2},{2,8,5},{3,5,2}};
		int[][] verticals = {{3,4,6},{4,1,6}};
		List<List<Integer>> result = si.intersections(horizontals, verticals);
		System.out.println(result);
	}

}
