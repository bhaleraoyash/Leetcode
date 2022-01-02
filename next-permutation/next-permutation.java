class Solution{
	public void nextPermutation(int[] nums){
		int smaller = -1;
        int right = nums.length - 1;		
        int larger = right;

		for(int i = nums.length - 1; i > 0; i--){
			if(nums[i] > nums[i - 1]){
				smaller = i - 1;
                break;
			}
		}
        
        if(smaller == -1){
            nums = reverse(nums, 0, right);
            return;
        }
		
        for(int i = nums.length - 1; i >= smaller + 1; i--){
            if(nums[i] > nums[smaller]){
                larger = i;
                break;
            }
        }
        
        int t = nums[smaller];
        nums[smaller] = nums[larger];
        nums[larger] = t;
        
        int index = smaller + 1;
        
		nums = reverse(nums, index, right);
	}
    
    public int[] reverse(int[] nums, int i, int j){
        while(i < j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
        return nums;
    }
}
