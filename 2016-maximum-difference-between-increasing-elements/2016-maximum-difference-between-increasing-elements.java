class Solution {
    public int maximumDifference(int[] nums) {
        int max = -1;
        int min = nums[0];
        
        for(int i = 0; i < nums.length; i++){
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i] - min);
        }
        
        return max <= 0 ? -1 : max;
    }
}