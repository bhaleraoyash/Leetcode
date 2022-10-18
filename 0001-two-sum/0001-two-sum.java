class Solution{
	public int[] twoSum(int[] nums, int target){
		Map<Integer, Integer> index = new HashMap<Integer, Integer>();
		int[] answer = new int[2];

		for(int i = 0; i < nums.length; i++){
			int num2 = target - nums[i];
			if(index.containsKey(num2) && index.get(num2) != i){
				answer[0] = i;
				answer[1] = index.get(num2);
			}
			else{
				index.put(nums[i], i);
			}
		}

		return answer;
	}
}
