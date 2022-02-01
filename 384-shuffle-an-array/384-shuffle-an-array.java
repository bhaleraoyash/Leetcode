class Solution{

	int[] original;
	int[] shuffled;
	Random random;
	
	public Solution(int[] nums){
		original = new int[nums.length];
		shuffled = new int[nums.length];
		original = nums.clone();
		shuffled = nums.clone();
		random = new Random();
	}

	public int[] reset(){
		return original;
	}

	public int[] shuffle(){
		for(int i = shuffled.length - 1; i >= 0; i--){
			int r = random.nextInt(i + 1);
			int temp = shuffled[i];
			shuffled[i] = shuffled[r];
			shuffled[r] = temp;
		}
		return shuffled;
	}
}
