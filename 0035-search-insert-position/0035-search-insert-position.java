class Solution {
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        
        while(low <= high){
            int mid = low + (high - low) / 2;
            int middle = nums[mid];
            if(target == middle){
                return mid;
            }
            else if(target < middle){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        
        return low;
    }
}