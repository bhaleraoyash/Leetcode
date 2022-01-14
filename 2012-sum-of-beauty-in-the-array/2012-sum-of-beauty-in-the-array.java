class Solution {
    public int sumOfBeauties(int[] nums) {
        int l = nums.length;
        int sum = 0;
        
        if(l == 0)
            return 0;
        
        int[] maxLeft = new int[l];
        int[] minRight = new int[l];
        maxLeft[0] = nums[0];
        minRight[l - 1] = nums[l - 1];
        
        for(int i = 1; i < l; i++){
            maxLeft[i] = Math.max(nums[i], maxLeft[i - 1]);
        }
        for(int i = l - 2; i >= 0; i--){
            minRight[i] = Math.min(nums[i], minRight[i + 1]);
        }
        
        for(int i = 1; i <= nums.length - 2; i++){
            if(maxLeft[i - 1] < nums[i] && nums[i] < minRight[i + 1]){
                sum += 2;
            }
            else if(nums[i - 1] < nums[i] && nums[i] < nums[i + 1]){
                sum += 1;
            }
        }
        
        return sum;
    }
}