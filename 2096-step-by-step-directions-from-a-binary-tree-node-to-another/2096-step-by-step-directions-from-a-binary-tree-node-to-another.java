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
    StringBuilder source = new StringBuilder();
    StringBuilder destination = new StringBuilder();
    
    public String getDirections(TreeNode root, int startValue, int destValue) {
        if(root == null){
            return "";
        }
        String answer = "";
        
        find(root, startValue, true);
        find(root, destValue, false);
        
        source.reverse();
        destination.reverse();
        
        int i = 0;
        while(i < source.length() && i < destination.length()){
            if(source.charAt(i) == destination.charAt(i)){
                i++;
            }
            else{
                break;
            }
        }
        
        
        for(int j = i; j < source.length(); j++){
            answer += "U";
        }
        
        answer += destination.substring(i);
        
        return answer.toString();
    }
    
    public boolean find(TreeNode root, int node, boolean isSource){
        if(root == null){
            return false;
        }
        if(root.val == node){
            return true;
        }
        boolean left = find(root.left, node, isSource);
        if(left){
            if(isSource){
                source.append("L");
            }
            else{
                destination.append("L");
            }
            return true;
        }
        boolean right = find(root.right, node, isSource);
        if(right){
            if(isSource){
                source.append("R");
            }
            else{
                destination.append("R");
            }
            return true;
        }
        return false;
    }
}