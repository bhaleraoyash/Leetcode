class Solution{
	public List<Integer> rightSideView(TreeNode root){
		List<Integer> answer = new ArrayList<Integer>();
		Queue<TreeNode> q = new LinkedList<TreeNode>();

        if(root == null){
            return answer;
        }
		q.offer(root);

		while(!q.isEmpty()){
            int level = q.size();
			for(int i = 0; i < level; i++){
				TreeNode temp = q.poll();
				if(i == level - 1){
					answer.add(temp.val);
				}
                if(temp.left != null){
					q.offer(temp.left);
				}
				if(temp.right != null){
					q.offer(temp.right);
				}
			}
		}
		
		return answer;
	}
}
