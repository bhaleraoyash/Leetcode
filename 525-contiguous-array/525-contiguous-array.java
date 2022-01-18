class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> counter = new HashMap<Integer, Integer>();
        counter.put(0, -1);
        int ans = 0;
        int count = 0;
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                count += 1;
            }
            else{
                count -= 1;
            }
            if(counter.containsKey(count)){
                ans = Math.max(ans, i - counter.get(count));
            }
            else{
                counter.put(count, i);
            }
        }
        return ans;
    }
}