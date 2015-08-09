package string;

import java.util.Stack;

public class SimplifyPath {

	/**
	 * Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
click to show corner cases.

Corner Cases:
Did you consider the case where path = "/../"?
In this case, you should return "/".
Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
In this case, you should ignore redundant slashes and return "/home/foo".
	 * @param args
	 */
	public static String simplifyPath(String path) {
		String newPath="";
		Stack<String> names =  new Stack<String>();
		String name="";
		for(int i=1;i<=path.length();i++){
			if(i==path.length() || path.charAt(i)=='/' ){
				if(name.equals(".")){
					name="";
				}
				else if(name.equals("..")){
					name="";
					if(!names.isEmpty())
						names.pop();
				}
				else if(!name.isEmpty()){
					names.push(name);
					name="";
				}
			}
			else{
				name+=(""+path.charAt(i));
			}
		}
		if(names.size()==0)
			return "/";
		else{
			
			for(String s:names){
				newPath+=("/"+s);
			}
		}
        return newPath;
    }
	
	public  String simplifyPath2(String path) {
		Stack<Integer> slashIndex = new Stack<Integer>();
		slashIndex.push(0);
		StringBuilder sb = new StringBuilder("/");
		int[][] trans = new int[][]{
				{0, 1, 0},
				{3, 1, 2},
				{0, 1, 2},
				{4, 1, 0},
				{0, 1, 0}
		};
		char[] chars = path.toCharArray();
		int state = 1;
		for (int i = 1; i < chars.length; i++) {
			int input = map(chars[i]);
			if (state ==2 && input == 1) {
				slashIndex.push(i);
			}
			if ( (state == 1 && input == 2) || (state == 2 &&(input == 1 || input == 2))) {
				sb.append(chars[i]);
			} else if (state == 4 && input == 1) {
				if (slashIndex.size() == 1) continue;
				int index2 = slashIndex.pop();
				int index1 = slashIndex.peek();
				sb.delete(index1+1, index2+1);
			}
			state = trans[state][input];
			if (state == 0) {
				return null;
			}
		}
		String re = sb.toString();
		if (re.endsWith("/")) re = re.substring(0,re.length()-1);
		return re;
		
	}
	
	
	
	private int map(char c) {
		if (c == '.') {
			return 0;
		} else if (c == '/') {
			return 1;
		} else {
			return 2;
		}
	}
	
	public static void main(String[] args) {
		String path="/a/./b/../../c/";
		SimplifyPath s = new SimplifyPath();
		String re = s.simplifyPath2(path);
		System.out.println(re);

	}

}
