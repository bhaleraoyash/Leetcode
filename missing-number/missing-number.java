class Solution {
    public int missingNumber(int[] nums) {
        Set<Integer> check = new HashSet<Integer>();
        int answer = 0;
        
        for(int i : nums){
            check.add(i);
        }
        
        for(int i = 0; i <= nums.length; i++){
            if(!check.contains(i)){
                answer = i;
            }
        }
        return answer;
    }
}