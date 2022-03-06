class Solution {
    public boolean check(int[] nums) {
        int[] compare = new int[nums.length];
        compare = nums.clone();
        Arrays.sort(compare);
        
        if(nums.equals(compare)){
            return true;
        }
        
        for(int i = 0; i < compare.length; i++){
            int j, last;        
            last = compare[compare.length - 1];
            for(j = compare.length - 1; j > 0; j--){
                compare[j] = compare[j - 1];    
            }  
            compare[0] = last;
            
            if(Arrays.equals(compare, nums)){
                return true;
            }
        }
        
        return false;
    }
}