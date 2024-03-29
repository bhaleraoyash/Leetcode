class Solution{
	public int maxSubArray(int[] nums){
		int answer = nums[0];
		int currentSum = nums[0];

		for(int i = 1; i < nums.length; i++){
			currentSum += nums[i];
            currentSum = Math.max(currentSum, nums[i]);
			answer = Math.max(answer, currentSum);
		}
		
		return answer;
	}
}