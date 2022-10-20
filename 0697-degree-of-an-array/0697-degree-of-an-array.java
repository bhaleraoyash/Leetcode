class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> counter = new HashMap<Integer, Integer>();
        Map<Integer, List<Integer>> indices = new HashMap<Integer, List<Integer>>();
        int answer = Integer.MAX_VALUE;
        
        for(int i = 0; i < nums.length; i++){
            counter.put(nums[i], counter.getOrDefault(nums[i], 0) + 1);
            if(!indices.containsKey(nums[i])){
                List<Integer> temp = new ArrayList<Integer>();
                temp.add(i);
                indices.put(nums[i], temp);
            }
            else{
                List<Integer> temp = indices.get(nums[i]);
                temp.add(i);
                indices.put(nums[i], temp);
            }
        }
        
        int max = Integer.MIN_VALUE;
        
        for(Integer i : counter.keySet()){
            max = Math.max(max, counter.get(i));   
        }
        
        for(Integer i : indices.keySet()){
            List<Integer> temp = indices.get(i);
            if(temp.size() == max){
                answer = Math.min(answer, (temp.get(temp.size() - 1) - temp.get(0)) + 1);
            }
        }
        
        return answer;
    }
}