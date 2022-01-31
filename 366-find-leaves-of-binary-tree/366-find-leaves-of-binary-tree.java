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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        
        if(root == null){
            return answer;
        }
        level(root, answer);
        
        return answer;
    }
    
    public int level(TreeNode root, List<List<Integer>> answer){
        if(root == null){
            return -1;
        }
        
        int level = Math.max(level(root.left, answer), level(root.right, answer)) + 1;
        if(answer.size() <= level){
            answer.add(new ArrayList<Integer>());
        }
        
        answer.get(level).add(root.val);
        return level;
    }
}