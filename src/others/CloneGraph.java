package others;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
 class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) { 
  	  label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
}
public class CloneGraph {

	/**
	 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


OJ's undirected graph serialization:
Nodes are labeled uniquely.

We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
As an example, consider the serialized graph {0,1,2#1,2#2,2}.

The graph has a total of three nodes, and therefore contains three parts as separated by #.

First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
Second node is labeled as 1. Connect node 1 to node 2.
Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
Visually, the graph looks like the following:

       1
      / \
     /   \
    0 --- 2
         / \
         \_/
	 * @param args
	 */
	
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node==null) return null;
        Queue<UndirectedGraphNode> queue=new LinkedList<UndirectedGraphNode>();
        HashMap<UndirectedGraphNode,UndirectedGraphNode> copied=new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        UndirectedGraphNode cn= new UndirectedGraphNode(node.label);
        queue.offer(cn);
        copied.put(node, cn);
        while(!queue.isEmpty()){
        	 UndirectedGraphNode current = queue.poll();
        	 for( UndirectedGraphNode nei: current.neighbors){
        		 UndirectedGraphNode newNei =null;
        		 if(!copied.containsKey(nei)){
        			 newNei=new UndirectedGraphNode(nei.label);
        			 copied.put(nei, newNei);
        		 }
        		 else newNei=copied.get(nei);
        		 current.neighbors.add(newNei);
        		 queue.offer(newNei);
        	 }
        }
        return copied.get(node);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
