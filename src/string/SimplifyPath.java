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
		Stack<String> names = new Stack<>();
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
	

	
	public static void main(String[] args) {
		String path="///";
		System.out.println(simplifyPath(path));
		Stack<String> names = new Stack<>();
		names.add("");
		names.add("");
		System.out.println(names.size());
		System.out.println(names.toString());
	}

}
