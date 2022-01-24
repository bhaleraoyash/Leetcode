class Solution{
	public List<String> findMissingRanges(int[] nums, int lower, int upper){
		List<String> answer = new ArrayList<String>();

		for(int i = 0; i < nums.length; i++){
			if(nums[i] > lower){
				if(nums[i] - lower == 1){
					answer.add(lower + "");
				}
				else{
					answer.add(lower + "->" + (nums[i] - 1));
				}
			}
			lower = nums[i] + 1;
		}
		
		if(lower < upper){
			answer.add(lower + "->" + upper);
		}
		else if(lower == upper){
			answer.add(lower + "");
		}

		return answer;
	}
}
