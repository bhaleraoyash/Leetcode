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
    List<Integer> nums = new ArrayList<Integer>();
    
    public boolean findTarget(TreeNode root, int k) {
        inorder(root);
        int left = 0;
        int right = nums.size() - 1;
        
        while(left < right){
            int sum = nums.get(left) + nums.get(right);
            if(sum < k){
                left++;
            }
            else if(sum > k){
                right--;
            }
            else{
                return true;
            }
        }
        
        return false;
    }
    
    public void inorder(TreeNode root){
        if(root == null){
            return;
        }
        
        inorder(root.left);
        nums.add(root.val);
        inorder(root.right);
    }
}