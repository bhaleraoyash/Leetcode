class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> counter = new HashMap<Integer, Integer>();
        Map<Integer, Integer> left = new HashMap<Integer, Integer>();
        Map<Integer, Integer> right = new HashMap<Integer, Integer>();
        int degree = -1;
        int answer = Integer.MAX_VALUE;
        
        for(int i = 0; i < nums.length; i++){
            counter.put(nums[i], counter.getOrDefault(nums[i], 0) + 1);
            if(!left.containsKey(nums[i])){
                left.put(nums[i], i);
            }
            right.put(nums[i], i);
        }
        
        degree = Collections.max(counter.values());
        
        for(Integer key : nums){
            if(counter.get(key) == degree){
                answer = Math.min(answer, (right.get(key) - left.get(key)) + 1);
            }
        }
        
        return answer;
    }
}