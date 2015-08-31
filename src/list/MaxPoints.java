package list;

/**
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 */
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

class Point {
	int x;
	int y;

	Point() {
		x = 0;
		y = 0;
	}

	Point(int a, int b) {
		x = a;
		y = b;
	}
}

public class MaxPoints {

	public static int maxPoints(Point[] points) {
		if ( points.length < 3) return points.length;
		int max = 0;
		for (int i = 0 ; i < points.length; i++){
			Map<Double,Integer> slops = new HashMap<Double, Integer>();
			int same = 0;
			int curMax = 0;
			for (int j = 0; j < points.length; j++){
				double slop = 0;
				if (points[j].x == points[i].x){
					if (points[j].y == points[i].y){
						same++;
						continue;
					}
					slop = Double.MAX_VALUE;
				} else {
					slop = 1.0 * (points[j].y - points[i].y) /(points[j].x - points[i].x);
				}
				Integer count = slops.get(slop);
				count = count == null ? 1 : count+1;
				slops.put(slop, count);
				if (count > curMax) curMax = count;
			}
			max = Math.max(max, curMax + same);
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point[] a = new Point[3];
		a[0] = new Point(2, 0);
		a[1] = new Point(1, 0);
		a[2] = new Point(3, 0);
		System.out.println(maxPoints(a));

	}

}
