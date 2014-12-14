package graph;

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
