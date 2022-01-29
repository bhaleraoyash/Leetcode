class Solution{
	public int[] productExceptSelf(int[] nums){
		int n = nums.length;
		int[] fromLeft = new int[n];
		int[] fromRight = new int[n];
		int[] answer = new int[n];
		int product = 1;

		for(int i = 0; i < n; i++){
            product *= nums[i];
			fromLeft[i] = product;
		}

		product = 1;
		for(int i = n - 1; i >= 0; i--){
            product *= nums[i];
			fromRight[i] = product;
		}

		for(int i = 0; i < n; i++){
			if(i == 0){
				answer[i] = fromRight[i + 1];
			}
			else if(i == n - 1){
				answer[i] = fromLeft[i - 1];
			}
			else{
				answer[i] = fromLeft[i - 1] * fromRight[i + 1];
			}
		}
		return answer;
	}
}
