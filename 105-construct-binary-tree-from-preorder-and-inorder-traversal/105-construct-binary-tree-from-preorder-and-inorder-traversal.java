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
class Solution {
    Map<Integer, Integer> inorderMap = new HashMap<Integer, Integer>();
    int preIndex;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preIndex = 0;
        
        for(int i = 0; i < inorder.length; i++){
            inorderMap.put(inorder[i], i);
        }
        
        return arrayToTree(preorder, 0, preorder.length - 1);
    }
    
    public TreeNode arrayToTree(int[] preorder, int left, int right){
        if(left > right) return null;
        
        TreeNode root = new TreeNode();
        root.val = preorder[preIndex++];
        
        root.left = arrayToTree(preorder, left, inorderMap.get(root.val) - 1);
        root.right = arrayToTree(preorder, inorderMap.get(root.val) + 1, right);
        
        return root;
    }
}