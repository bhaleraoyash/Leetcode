class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> counter = new HashMap<Integer, Integer>();
        Map<Integer, List<Integer>> index = new HashMap<Integer, List<Integer>>();
        int answer = Integer.MAX_VALUE;
        
        for(int i = 0; i < nums.length; i++){
            counter.put(nums[i], counter.getOrDefault(nums[i], 0) + 1);
            if(index.containsKey(nums[i])){
                index.get(nums[i]).add(i);
            }
            else{
                List<Integer> temp = new ArrayList<Integer>();
                temp.add(i);
                index.put(nums[i], temp);
            }
        }
        
        int max = Collections.max(counter.values());
        
        for(int i : index.keySet()){
            if(counter.get(i) == max){
                List<Integer> temp = index.get(i);
                int current = temp.get(temp.size() - 1) - temp.get(0) + 1;
                answer = Math.min(current, answer);
            }
        }
        
        return answer;
    }
}