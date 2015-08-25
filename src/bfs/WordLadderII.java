package bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * Given two words (start and end), and a dictionary, find all shortest
 * transformation sequence(s) from start to end, such that:
 * 
 * Only one letter can be changed at a time Each intermediate word must exist in
 * the dictionary For example,
 * 
 * Given: start = "hit" end = "cog" dict = ["hot","dot","dog","lot","log"]
 * Return [ ["hit","hot","dot","dog","cog"], ["hit","hot","lot","log","cog"] ]
 * 
 * @param args
 */
public class WordLadderII {

	List<List<String>> results = new ArrayList<List<String>>();
	HashMap<String, List<String>> parents = new HashMap<String, List<String>>();
	Set<String> dict;
	public List<List<String>> findLadders(String start, String end,Set<String> dict) {
		this.dict = dict;
		parents.put(start, null);
		Queue<String> queue = new LinkedList<String>();
		queue.offer(start);
		boolean findMin = false;
		while ( !findMin && !queue.isEmpty()){
			int size = queue.size();
			HashMap<String, List<String>> curParents = new HashMap<String, List<String>>();
			for (int i = 0; i < size; i++){
				List<String> candis = candidate(queue.poll(),curParents);
				for (String candi:candis){
					if (end.equals(candi)){
						findMin = true;
					} 
					queue.offer(candi);
				}
			}
			parents.putAll(curParents);
			if (findMin){
				genPath(start, end, new LinkedList<String>());
				return results;
			}
		}
		return null;
	}
	


	private List<String> candidate(String s,HashMap<String, List<String>> curParents){
		List<String> candis = new ArrayList<String>();
		for (int i = 0; i< s.length(); i++){
			for (char c = 'a'; c <='z'; c++){
				if (s.charAt(i) != c){
					String candi = s.substring(0, i)+c+s.substring(i+1);
					if (!dict.contains(candi)) continue;
					if (!parents.containsKey(candi)){
						candis.add(candi);
						put(curParents,s,candi);
					} 
					
				}
			}
		}
		
		return candis;
	}
	
	private void put(HashMap<String, List<String>> curParents,String parent,String candi){
		List<String> pa = curParents.get(candi);
		if (pa == null)
			pa = new ArrayList<String>();
		pa.add(parent);
		curParents.put(candi, pa);
	}

	private void genPath(String start,String cur, List<String> curPath){
		if (cur.equals(start)){
			curPath.add(0, cur);
			results.add(curPath);
			return;
		}
		for (String  pa : parents.get(cur)){
			LinkedList<String> path = new LinkedList<String>(curPath);
			path.add(0, cur);
			genPath(start, pa, path);
		}
	}


	public static void main(String[] args) {
		WordLadderII wd2 = new WordLadderII();
		String start = "hot";
		String end ="tot";
		Set<String> dict  = new HashSet<String>(Arrays.asList("hot","cog","dog","tot","hog","hop","pot","dot"));
		List<List<String>> results = wd2.findLadders(start, end, dict);
		System.out.println(results);
	}

}
