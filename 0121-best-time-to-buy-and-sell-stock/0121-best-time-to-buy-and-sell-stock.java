class Solution {
    public int maxProfit(int[] prices) {
        int answer = 0;
        int current = Integer.MAX_VALUE;
        
        for(int i = 0; i < prices.length; i++){
            answer = Math.max(answer, prices[i] - current);
            current = Math.min(current, prices[i]);
        }
        
        return answer;
    }
}