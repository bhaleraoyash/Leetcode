class Solution {
    public int maxSubArray(int[] nums) {
        int current_subarray = nums[0];
        int max_subarray = nums[0];
        
        for(int i = 1; i < nums.length; i++){
            current_subarray = Math.max(nums[i], current_subarray + nums[i]);
            max_subarray = Math.max(max_subarray, current_subarray);
        }
        
        return max_subarray;
    }
}