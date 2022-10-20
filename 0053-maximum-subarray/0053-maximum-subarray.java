class Solution{
	public int maxSubArray(int[] nums){
        if(nums.length == 1){
            return nums[0];
        }
		int answer = nums[0];
        int currentSum = nums[0];

		for(int i = 1; i < nums.length; i++){
            currentSum += nums[i];
			if(nums[i] > currentSum){
                currentSum = nums[i];
            }
            answer = Math.max(answer, currentSum);
		}

		return answer;
	}
}