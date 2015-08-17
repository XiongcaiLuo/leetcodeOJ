package string;

import java.util.Stack;

/**
 * Given an absolute path for a file (Unix-style), simplify it.
 * 
 * For example, path = "/home/", => "/home" path = "/a/./b/../../c/", => "/c"
 * click to show corner cases.
 * 
 * Corner Cases: Did you consider the case where path = "/../"? In this case,
 * you should return "/". Another corner case is the path might contain multiple
 * slashes '/' together, such as "/home//foo/". In this case, you should ignore
 * redundant slashes and return "/home/foo".
 * 
 * @param args
 */
public class SimplifyPath {

	public static String simplifyPath(String path) {
		String newPath = "";
		Stack<String> names = new Stack<String>();
		String name = "";
		for (int i = 1; i <= path.length(); i++) {
			if (i == path.length() || path.charAt(i) == '/') {
				if (name.equals(".")) {
					name = "";
				} else if (name.equals("..")) {
					name = "";
					if (!names.isEmpty())
						names.pop();
				} else if (!name.isEmpty()) {
					names.push(name);
					name = "";
				}
			} else {
				name += ("" + path.charAt(i));
			}
		}
		if (names.size() == 0)
			return "/";
		else {

			for (String s : names) {
				newPath += ("/" + s);
			}
		}
		return newPath;
	}



	
	/**
	 * use string.split();
	 * @param path
	 * @return
	 */
    public String simplifyPath2(String path) {
        String[] tokens = path.split("/");
        Stack<String> names = new Stack<String>();
		for (String token: tokens){
			if ("..".equals(token)){
				if (!names.isEmpty()) names.pop();
			}
			else if (token.isEmpty() || ".".equals(token))
				continue;
			else names.push(token);
		}
		if(names.isEmpty())
			return "/";
		String result = "";
		while (!names.isEmpty())
			result = "/"+names.pop()+result;
		return result;
    }

    
	/**
	 * no use split function
	 * @param path
	 * @return
	 */
    public String simplifyPath3(String path) {
        Stack<String> names = new Stack<String>();
		int i = 1, j=1;
		while (j <= path.length()){
			if (j == path.length() || path.charAt(j) == '/' ){
				String dir = path.substring(i,j);
				if ("..".equals(dir)){
					if (!names.isEmpty())
						names.pop();
				} else if(!dir.isEmpty() && !dir.equals(".")) 
					names.push(dir);
				j++;
				i = j;
			} else j++;
		}
		if(names.isEmpty())
			return "/";
		String result = "";
		while (!names.isEmpty())
			result = "/"+names.pop()+result;
		return result;
    }
	public static void main(String[] args) {
		SimplifyPath sp = new SimplifyPath();
		String path = "/..";
		String re = sp.simplifyPath3(path);
		System.out.println(re);
		
//		String s = "/a//../b/./";
//		String[] tokens = s.split("/");
//		System.out.println(tokens);

	}

}
