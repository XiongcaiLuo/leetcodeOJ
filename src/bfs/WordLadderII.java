//package bfs;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Queue;
//import java.util.Set;
//
//public class WordLadderII {
//
//	/**Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:
//
//Only one letter can be changed at a time
//Each intermediate word must exist in the dictionary
//For example,
//
//Given:
//start = "hit"
//end = "cog"
//dict = ["hot","dot","dog","lot","log"]
//Return
//  [
//    ["hit","hot","dot","dog","cog"],
//    ["hit","hot","lot","log","cog"]
//  ]
//	 * @param args
//	 */
//	List<List<String>> result = new ArrayList<List<String>>();
//    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
//		if (start == null || end == null || start.equals(end)
//				|| start.length() != end.length())
//			return result;
//
//		if (isOneWordDiff(start, end)){
//			List<String> path=new ArrayList<String>();
//			path.add(start);
//			path.add(end);
//			result.add(path);
//			return result;
//		}
//		
//		ladderLength(start,end,dict);
//		return result;
//			
//    }
//    
//	public void ladderLength(String start, String end, Set<String> dict) {
//
//
//		Queue<String> queue=new LinkedList<String>();
//		HashMap<String,Integer> dist=new HashMap<String,Integer>();
//		
//		queue.add(start);
//		dist.put(start, 1);
//		
//		while(!queue.isEmpty())
//		{
//			String head=queue.poll();
//			int headDist=dist.get(head);
//			for(int i=0;i<head.length();i++)
//			{
//				for(char j='a';j<'z';j++)
//				{
//					if(head.charAt(i)==j) continue;
//					
//					StringBuilder sb=new StringBuilder(head);
//					sb.setCharAt(i, j);
//					
//					if(sb.toString().equals(end)) return headDist+1;
//					
//					if(dict.contains(sb.toString())&&!dist.containsKey(sb.toString()))
//					{
//						queue.add(sb.toString());
//						dist.put(sb.toString(), headDist+1);
//					}
//				}
//			}
//		}
//
//		}
//
//
//
//	private boolean isOneWordDiff(String start, String end) {
//		int diff=0;
//		for(int i=0 ;i<start.length();i++){
//			if(start.charAt(i)!=end.charAt(i))
//				diff++;
//		}
//		return diff==1;
//	}
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
//
//}
