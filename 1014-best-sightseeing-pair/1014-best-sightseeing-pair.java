class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int best = values[0];
        int ans = 0;

        for(int j = 1; j < values.length; j++){
            ans = Math.max(ans, best + (values[j] - j));
            best = Math.max(best, (values[j] + j));
        }
        return ans;
    }
}