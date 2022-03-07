class Solution {
    public int lengthOfLIS(int[] nums) {
        TreeSet<Integer> temp = new TreeSet<Integer>();
        
        for(int i : nums){
            Integer higherOrEqual = temp.ceiling(i);
            if(higherOrEqual == null){
                temp.add(i);
            }
            else{
                temp.remove(higherOrEqual);
                temp.add(i);
            }
        }
        
        return temp.size();
    }
}