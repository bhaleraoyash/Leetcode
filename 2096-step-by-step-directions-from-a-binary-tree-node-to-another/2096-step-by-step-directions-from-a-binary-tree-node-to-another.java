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
	StringBuilder source = new StringBuilder();
	StringBuilder destination = new StringBuilder();

	public String getDirections(TreeNode root, int startValue, int destValue){
		StringBuilder answer = new StringBuilder();

		dfs(root, startValue, true);
		dfs(root, destValue, false);
        
        source.reverse();
        destination.reverse();
		
		int i = 0;
		int j = 0;
		while(i < source.length() && j < destination.length()){
			if(source.charAt(i) == destination.charAt(j)){
				i++;
				j++;
			}
			else{
				break;
			}
		}

		while(i < source.length()){
			answer.append("U");
			i++;
		}

		while(j < destination.length()){
			answer.append(destination.charAt(j));
			j++;
		}
		return answer.toString();
	}

	public boolean dfs(TreeNode root, int node, boolean sourceFlag){
		if(root == null){
			return false;
		}

		if(root.val == node){
			return true;
		}

		boolean left = dfs(root.left, node, sourceFlag);
		if(left){
			if(sourceFlag){
				source.append("L");
			}
			else{
				destination.append("L");
			}
            return true;
		}

		boolean right = dfs(root.right, node, sourceFlag);
		if(right){
			if(sourceFlag){
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
