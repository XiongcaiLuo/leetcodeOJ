import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;


public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
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
}