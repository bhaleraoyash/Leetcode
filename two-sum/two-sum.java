class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indices = new HashMap<Integer, Integer>();
        int[] answer = new int[2];
        
        for(int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if(indices.containsKey(complement)){
                answer[0] = i;
                answer[1] = indices.get(complement);
                break;
            }
            indices.put(nums[i], i);
        }
        return answer;
    }
}