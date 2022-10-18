class Solution{
	public int maxArea(int[] height){
		int left = 0;
		int right = height.length - 1;
		int answer = 0;

		while(left <= right){
			int area = (right - left) * Math.min(height[left], height[right]);
			if(height[left] < height[right]){
				left++;
			}
			else{
				right--;
			}
			answer = Math.max(answer, area);
		}

		return answer;
	}
}
