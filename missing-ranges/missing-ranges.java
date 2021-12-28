class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> answer = new ArrayList<String>();
        int previous = lower - 1;
        
        for(int i = 0; i <= nums.length; i++){
            int current = 0;
            if(i < nums.length){
                current = nums[i];
            }
            else{
                current = upper + 1;
            }
            if(previous + 1 <= current - 1){
                if(previous + 1 < current - 1){
                    String s = String.valueOf(previous + 1) + "->" + String.valueOf(current - 1);
                    answer.add(s);
                }
                else{
                    String s = String.valueOf(previous + 1);
                    answer.add(s);
                }
            }
            previous = current;
        }
        return answer;
    }
}
