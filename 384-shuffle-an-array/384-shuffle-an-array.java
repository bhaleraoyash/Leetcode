class Solution {

    int[] original;
    int[] shuffled;
    
    public Solution(int[] nums) {
        original = new int[nums.length];
        shuffled = new int[nums.length];
        original = nums.clone();
        shuffled = nums.clone();
    }
    
    public int[] reset() {
        return original;
    }
    
    public int[] shuffle() {
        List<Integer> temp = new ArrayList<Integer>();
        for(int i = 0; i < shuffled.length; i++){
            temp.add(shuffled[i]);
        }
        Collections.shuffle(temp);
        int index = 0;
        for(int j : temp){
            shuffled[index] = j;
            index++;
        }
        return shuffled;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */