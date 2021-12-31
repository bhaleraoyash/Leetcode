class Solution{
	public List<List<Integer>> threeSum(int[] nums){
		List<List<Integer>> answer = new ArrayList<List<Integer>>();
        Set<List<Integer>> set = new HashSet<List<Integer>>();

		if(nums.length < 3){
			return answer;
		}
        
        Arrays.sort(nums);
		
        int i = 0;
        
		while(i <= nums.length - 3){
            int complement = 0 - nums[i];
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k){
                int sum = nums[j] + nums[k];
                if(sum < complement){
                    j++;
                }
                else if(sum > complement){
                    k--;
                }
                else if(sum == complement){
                    List<Integer> result = new ArrayList<Integer>();
                    result.add(nums[i]);
                    result.add(nums[j]);
                    result.add(nums[k]);
                    set.add(result);
                    j++;
                }
            }
            i++;
        }
        for(List<Integer> s : set){
            answer.add(s);
        }
		return answer;
	}
}
