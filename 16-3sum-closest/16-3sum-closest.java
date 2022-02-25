class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int answer = 0;
        int difference = Integer.MAX_VALUE;
        
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                for(int k = j + 1; k < nums.length; k++){
                    int sum = nums[i] + nums[j] + nums[k];
                    int current = Math.abs(sum - target);
                    if(current < difference){
                        answer = sum;
                        difference = current;
                    }
                }
            }
        }
        
        return answer;
    }
}