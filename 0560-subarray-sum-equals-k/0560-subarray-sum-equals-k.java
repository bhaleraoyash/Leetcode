class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap<Integer, Integer>();
        int sum = 0;
        int answer = 0;
        counter.put(0, 1);
        
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(counter.containsKey(sum - k)){
                answer += counter.get(sum - k);
            }
            counter.put(sum, counter.getOrDefault(sum, 0) + 1);
        }
        
        return answer;
    }
}