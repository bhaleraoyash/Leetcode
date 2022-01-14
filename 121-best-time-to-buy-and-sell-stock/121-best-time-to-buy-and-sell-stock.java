class Solution{
	public int maxProfit(int[] prices){
		int min = Integer.MAX_VALUE;
		int answer = 0;
		
		for(int i = 0; i < prices.length; i++){
			if(prices[i] < min){
				min = prices[i];
			}
			if(prices[i] - min > answer){
				answer = prices[i] - min;
			}
		}
		return answer;
	}
}
