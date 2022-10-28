class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int[] answer = new int[nums.length];
        
        int product = 1;
        for(int i = 0; i < nums.length; i++){
            product *= nums[i];
            left[i] = product;
        }
        
        product = 1;
        for(int i = nums.length - 1; i >= 0; i--){
            product *= nums[i];
            right[i] = product;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(i == 0){
                answer[i] = right[1];
            }
            else if(i == nums.length - 1){
                answer[i] = left[nums.length - 2];
            }
            else{
                answer[i] = left[i - 1] * right[i + 1];
            }
        }
        
        return answer;
    }
}