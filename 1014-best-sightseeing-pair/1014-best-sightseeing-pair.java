class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int res = Integer.MIN_VALUE;
        int left = values[0];
        int right = 0;

        for(int i = 1; i < values.length; i++ )
        {
            right = values[i] - i;
            res = Math.max(res, left + right);
            left = Math.max(left, (values[i] + i));
        }

        return res;
    }
}