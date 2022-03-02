class Solution {
    public int lengthOfLIS(int[] nums) {
        TreeSet<Integer> answer = new TreeSet<Integer>();
        
        for(int i : nums){
            Integer higherOrEqual = answer.ceiling(i);
            if(higherOrEqual == null){
                answer.add(i);
            }
            else{
                answer.remove(higherOrEqual);
                answer.add(i);
            }
        }
        
        return answer.size();
    }
}