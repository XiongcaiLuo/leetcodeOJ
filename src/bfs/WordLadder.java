package bfs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

	/**
	 * Given two words (start and end), and a dictionary, find the length of
	 * shortest transformation sequence from start to end, such that:
	 * 
	 * Only one letter can be changed at a time Each intermediate word must
	 * exist in the dictionary For example,
	 * 
	 * Given: start = "hit" end = "cog" dict = ["hot","dot","dog","lot","log"]
	 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" ->
	 * "cog", return its length 5.
	 * 
	 * Note: Return 0 if there is no such transformation sequence. All words
	 * have the same length. All words contain only lowercase alphabetic
	 * characters.
	 * 
	 * @param args
	 */

	public int ladderLength(String start, String end, Set<String> dict) {
		if (start == null || end == null || start.equals(end)
				|| start.length() != end.length())
			return 0;

		if (isOneWordDiff(start, end))
			return 2;

		Queue<String> queue=new LinkedList<String>();
		HashMap<String,Integer> dist=new HashMap<String,Integer>();
		
		queue.add(start);
		dist.put(start, 1);
		
		while(!queue.isEmpty())
		{
			String head=queue.poll();
			int headDist=dist.get(head);
			for(int i=0;i<head.length();i++)
			{
				for(char j='a';j<'z';j++)
				{
					if(head.charAt(i)==j) continue;
					
					StringBuilder sb=new StringBuilder(head);
					sb.setCharAt(i, j);
					
					if(sb.toString().equals(end)) return headDist+1;
					
					if(dict.contains(sb.toString())&&!dist.containsKey(sb.toString()))
					{
						queue.add(sb.toString());
						dist.put(sb.toString(), headDist+1);
					}
				}
			}
		}
		return 0;
		}



	private boolean isOneWordDiff(String start, String end) {
		int diff=0;
		for(int i=0 ;i<start.length();i++){
			if(start.charAt(i)!=end.charAt(i))
				diff++;
		}
		return diff==1;
	}

}
