package graph;
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
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;

	UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
};

public class CloneGraph {

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node==null ) return null;
        Queue<UndirectedGraphNode> queue =  new LinkedList<UndirectedGraphNode>();
        HashMap<UndirectedGraphNode,UndirectedGraphNode> copy= new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
        copy.put(node, new UndirectedGraphNode(node.label));
        queue.offer(node);
        while(!queue.isEmpty()){
        	UndirectedGraphNode curOld= queue.poll();
        	UndirectedGraphNode curNew=copy.get(curOld);
        	for(UndirectedGraphNode nei:curOld.neighbors){
        		UndirectedGraphNode neiNew=null;
        		if(!copy.containsKey(nei)){
        			neiNew=new UndirectedGraphNode(nei.label);
        			copy.put(nei, neiNew);
        			queue.offer(nei);
        		}
        		else neiNew = copy.get(nei);
        		curNew.neighbors.add(neiNew);
        		
        	}
        	
        }
        return copy.get(node);
        
    }

}
