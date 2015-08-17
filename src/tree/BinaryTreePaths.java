package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;
/**
 * 
 * @author luoxiongcai
 *
 */
public class BinaryTreePaths {
	HashMap<TreeNode, TreeNode> parents = new HashMap<TreeNode,TreeNode>();
	List<String> results = new ArrayList<String>();
    public List<String> binaryTreePaths(TreeNode root) {
    	if (root != null) dfs(root);
    	return results;
        
    }
    
    private void dfs(TreeNode node){
    	if (node.left == null && node.right == null){
    		print(node);
    		return;
    	}
    	if (node.left != null){
    		parents.put(node.left,node);
    		dfs(node.left);
    	}
    	if (node.right != null){
    		parents.put(node.right, node);
    		dfs(node.right);
    	}
    }
    
    private void print (TreeNode node){
    	Stack<String> sb = new Stack<String>();
    	sb.push(""+node.val);
    	while ((node = parents.get(node)) != null){
    		sb.push("->");
    		sb.push(""+node.val);
    	}
    	StringBuilder rsb = new StringBuilder();
    	while (!sb.isEmpty())
    		rsb.append(sb.pop());
    	results.add(rsb.toString());
    }
	public static void main(String[] args) {
		
	}

}
