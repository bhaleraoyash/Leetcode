class Solution {
    public int subarraySum(int[] nums, int k) {
        int answer = 0;
        int sum = 0;
        Map<Integer, Integer> sumFreq = new HashMap<Integer, Integer>();
        sumFreq.put(0, 1);
        
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            int temp = sum - k;
            if(sumFreq.containsKey(temp)){
                answer += sumFreq.get(temp);
            }
            sumFreq.put(sum, sumFreq.getOrDefault(sum, 0) + 1);
        }
        
        return answer;
    }
}