class Solution{
	public int lengthOfLIS(int[] nums){
		TreeSet<Integer> answer = new TreeSet<Integer>();
        
        for(int num : nums){
            Integer higherOrEqual = answer.ceiling(num);
            if(higherOrEqual == null){
                answer.add(num);
            }
            else{
                answer.remove(higherOrEqual);
                answer.add(num);
            }
        }
        
		return answer.size();
	}
}
