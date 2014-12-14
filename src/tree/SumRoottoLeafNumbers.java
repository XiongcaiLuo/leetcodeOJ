package tree;

public class SumRoottoLeafNumbers {

	/**
	 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.
	 * @param args
	 */
	public int sum;
    public int sumNumbers(TreeNode root) {
        sum=0;
        int currentSum=0;
        addNumbers(root,currentSum);
        return sum;
    }
	private void addNumbers(TreeNode root,int currentSum) {
		if(root==null) return ;
		if(root.left==null && root.right==null){
			sum+=currentSum*10+root.val;
		}else{
			addNumbers(root.left,currentSum*10+root.val);
			addNumbers(root.right,currentSum*10+root.val);
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
