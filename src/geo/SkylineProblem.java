package geo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * A city's skyline is the outer contour of the silhouette formed by all the
 * buildings in that city when viewed from a distance. Now suppose you are given
 * the locations and height of all the buildings as shown on a cityscape photo
 * (Figure A), write a program to output the skyline formed by these buildings
 * collectively (Figure B).
 * 
 * Buildings Skyline Contour The geometric information of each building is
 * represented by a triplet of integers [Li, Ri, Hi], where Li and Ri are the x
 * coordinates of the left and right edge of the ith building, respectively, and
 * Hi is its height. It is guaranteed that 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤
 * INT_MAX, and Ri - Li > 0. You may assume all buildings are perfect rectangles
 * grounded on an absolutely flat surface at height 0.
 * 
 * For instance, the dimensions of all buildings in Figure A are recorded as: [
 * [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] .
 * 
 * The output is a list of "key points" (red dots in Figure B) in the format of
 * [ [x1,y1], [x2, y2], [x3, y3], ... ] that uniquely defines a skyline. A key
 * point is the left endpoint of a horizontal line segment. Note that the last
 * key point, where the rightmost building ends, is merely used to mark the
 * termination of the skyline, and always has zero height. Also, the ground in
 * between any two adjacent buildings should be considered part of the skyline
 * contour.
 * 
 * For instance, the skyline in Figure B should be represented as:[ [2 10], [3
 * 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ].
 * 
 * Notes:
 * 
 * The number of buildings in any input list is guaranteed to be in the range
 * [0, 10000]. The input list is already sorted in ascending order by the left x
 * position Li. The output list must be sorted by the x position. There must be
 * no consecutive horizontal lines of equal height in the output skyline. For
 * instance, [...[2 3], [4 5], [7 5], [11 5], [12 7]...] is not acceptable; the
 * three lines of height 5 should be merged into one in the final output as
 * such: [...[2 3], [4 5], [12 7], ...]
 * 
 * @author luoxiongcai
 *
 */

public class SkylineProblem {

	/**
	 * useful for small range :(
	 * @param buildings
	 * @return
	 */
    public List<int[]> getSkyline(int[][] buildings) {
        int min = buildings[0][0];
        int max = Integer.MIN_VALUE;
        for (int[] b : buildings){
        	max = Math.max(b[1], max);
        }
        int[] mark =  new int[max - min];
        for (int[] b : buildings){
        	for (int i = b[0]; i < b[1]; i++){
        		if (b[2] > mark[i-min])
        			mark[i-min] = b[2];
        	}
        }
        List<int[]> result = new ArrayList<int[]>();
        int last = -1;
        for (int i = 0 ; i < max - min; i++){
        	if (last != mark[i]){
        		result.add(new int[]{i + min, mark[i]});
        		last = mark[i];
        	}
        }
        result.add(new int[]{max,0});
        return result;
    }
    
    /**
     * good
     * @param buildings
     * @return
     */
    public List<int[]> getSkyline2(int[][] buildings) {
        List<int[]> res = new ArrayList<int[]>();
        if (buildings == null || buildings.length == 0 || buildings[0].length == 0) {
            return res;
        }
        List<Edge> edges = new ArrayList<Edge>();
        for (int[] building : buildings) {
            Edge startEdge = new Edge(building[0], building[2], true);
            edges.add(startEdge);
            Edge endEdge = new Edge(building[1], building[2], false);
            edges.add(endEdge);
        }
        //sort edges according to position, height, and if the edge is start or end
        Collections.sort(edges,new Comparator<Edge>(){
            public int compare(Edge l1, Edge l2) {
                if (l1.pos != l2.pos)
                    return Integer.compare(l1.pos, l2.pos);
                if (l1.isStart && l2.isStart) {
                    return Integer.compare(l2.height, l1.height);
                }
                if (!l1.isStart && !l2.isStart) {
                    return Integer.compare(l1.height, l2.height);
                }
                return l1.isStart ? -1 : 1;
            }
        });
        //heap of height
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(10, Collections.reverseOrder());
        for (Edge edge : edges) {
            if (edge.isStart) {
                if (heap.isEmpty() || edge.height > heap.peek()) {
                    res.add(new int[]{edge.pos, edge.height});
                }
                heap.add(edge.height);
            } else {
                heap.remove(edge.height);
                if (heap.isEmpty() || edge.height > heap.peek()) {
                    res.add(heap.isEmpty() ? new int[]{edge.pos,0} : new int[]{edge.pos, heap.peek()});
                }
            }
        }
        return res;
    }
    class Edge{
        int pos;
        int height;
        boolean isStart;
        public Edge(int pos, int height, boolean isStart) {
            this.pos = pos;
            this.height = height;
            this.isStart = isStart;
        }

    }
	public static void main(String[] args) {
		SkylineProblem sp = new SkylineProblem();
		int[][] buildings = {{1,2,1},{1,2,2},{1,2,3}};
		List<int[]> re = sp.getSkyline(buildings);
		for (int[] r : re)
			System.out.println(r[0]+"\t"+r[1]);
	}

}
