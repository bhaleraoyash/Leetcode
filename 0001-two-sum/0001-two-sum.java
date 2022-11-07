class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> index = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < nums.length; i++){
            int remainder = target - nums[i];
            if(index.containsKey(remainder) && index.get(remainder) != i){
                return new int[]{i, index.get(remainder)};
            }
            index.put(nums[i], i);
        }
        
        return new int[0];
    }
}