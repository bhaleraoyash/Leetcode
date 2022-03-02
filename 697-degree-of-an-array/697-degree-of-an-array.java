class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> counter = new HashMap<Integer, Integer>();
        Map<Integer, List<Integer>> indices = new HashMap<Integer, List<Integer>>();
        int degree = -1;
        int answer = Integer.MAX_VALUE;
        
        for(int i = 0; i < nums.length; i++){
            counter.put(nums[i], counter.getOrDefault(nums[i], 0) + 1);
            if(indices.containsKey(nums[i])){
                indices.get(nums[i]).add(i);
            }
            else{
                List<Integer> temp = new ArrayList<Integer>();
                temp.add(i);
                indices.put(nums[i], temp);
            }
        }
        
        degree = Collections.max(counter.values());
        
        for(Integer key : indices.keySet()){
            if(counter.get(key) == degree){
                List<Integer> temp = indices.get(key);
                int min = Collections.min(temp);
                int max = Collections.max(temp);
                answer = Math.min(answer, (max - min) + 1);
            }
        }
        
        return answer;
    }
}