/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution{
	int postIndex;
	Map<Integer, Integer> inorderMap = new HashMap<Integer, Integer>();

	public TreeNode buildTree(int[] inorder, int[] postorder){
		postIndex = postorder.length - 1;

		for(int i = 0; i < inorder.length; i++){
			inorderMap.put(inorder[i], i);
		}

		return arrayToTree(postorder, 0, inorder.length - 1);
	}

	public TreeNode arrayToTree(int[] postorder, int left, int right){
		if(left > right){
			return null;
		}

		TreeNode root = new TreeNode();
		root.val = postorder[postIndex--];

        root.right = arrayToTree(postorder, inorderMap.get(root.val) + 1, right);
		root.left = arrayToTree(postorder, left, inorderMap.get(root.val) - 1);

		return root;
	}
}
