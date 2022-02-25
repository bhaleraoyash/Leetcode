class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int left = values[0];
        int answer = 0;
        
        for(int i = 1; i < values.length; i++){
            answer = Math.max(answer, left + (values[i] - i));
            left = Math.max(left, values[i] + i);
        }
        
        return answer;
    }
}