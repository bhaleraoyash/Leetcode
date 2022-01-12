class Solution{
	public int[] searchRange(int[] nums, int target){
		int[] answer = new int[2];
        answer[0] = findStartingIndex(nums, target);
        answer[1] = findEndingIndex(nums, target);
        return answer;
	}
    
    public int findStartingIndex(int[] nums, int target){
        int index = -1;
        int low = 0;
        int high = nums.length - 1;
        
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] >= target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
            if(nums[mid] == target) index = mid;
        }
        return index;
    }
    
    public int findEndingIndex(int[] nums, int target){
        int index = -1;
        int low = 0;
        int high = nums.length - 1;
        
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] <= target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
            if(nums[mid] == target) index = mid;
        }
        return index;
    }
}
