package tree;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {

	/**
	 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
	 * @param args
	 */
	/**
	 * maybe over time; but require less space;
	 * @param n
	 * @return
	 */
    public List<TreeNode> generateTrees(int n) {
    	List<TreeNode> re= new ArrayList<TreeNode>();
    	if(n==0){
    		re.add(null);
    		return re;
    	} 
    	re=genSubTree(1, n);
    	return re;
    }
    
    private List<TreeNode> genSubTree(int begin,int end){
    	if(begin>end) return null;
    	ArrayList<TreeNode> re =  new ArrayList<TreeNode>();
    	if(begin == end){
    		re.add(new TreeNode(begin));
    		return re;
    	}
    	for(int i=begin;i<=end;i++){
    		List<TreeNode> left=genSubTree(begin,i-1);
    		List<TreeNode> right=genSubTree(i+1,end);
    		if(left==null){
        		for(TreeNode rightRoot: right){
        			TreeNode root = new TreeNode(i);
        			root.right=rightRoot;
        			re.add(root);
        		}
    		}
    		else if(right == null){
    			for(TreeNode leftRoot: left){
    				TreeNode root = new TreeNode(i);
    				root.left = leftRoot;
    				re.add(root);
    			}
    		}
    		else{
    			for(TreeNode leftRoot: left){
    				for(TreeNode rightRoot: right){
    					TreeNode root = new TreeNode(i);
    					root.left =  leftRoot;
    					root.right = rightRoot;
    					re.add(root);
    				}
    			}
    		}
    		
    	}
    	return re;
    }
    
    public static void main(String[]args){
    	UniqueBinarySearchTreesII t =  new UniqueBinarySearchTreesII();
    	List<TreeNode> re=t.generateTrees(3);
    	System.out.println("done:"+re.size());
    }
}

