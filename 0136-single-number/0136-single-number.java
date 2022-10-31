class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> counter = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < nums.length; i++){
            counter.put(nums[i], counter.getOrDefault(nums[i], 0) + 1);
        }
        
        for(int key : counter.keySet()){
            if(counter.get(key) == 1){
                return key;
            }
        }
        
        return -1;
    }
}