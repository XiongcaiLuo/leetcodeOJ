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
	int sum = 0;
    public int sumNumbers(TreeNode root) {
        sum(root,0);
        return sum;
    }
	private void sum(TreeNode root, int cursum) {
		if (root == null) return;
		if (root.left == null && root.right == null){
			sum += cursum * 10 +root.val;
		}
		if (root.left != null)
			sum(root.left, cursum * 10 + root.val);
		if (root.right != null)
			sum(root.right , cursum * 10 + root.val);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
