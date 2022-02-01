class Solution {
    public long maxPoints(int[][] points) {
        int n = points.length;
        int m = points[0].length;
        long[][] dp = new long[n][m];
        
        for(int j = 0; j < m; j++){
            dp[0][j] = points[0][j];
        }
        
        for(int i = 1; i < n; i++){
            long[] left = new long[m];
            left[0] = dp[i - 1][0];
            for(int k = 1; k < m; k++){
                left[k] = Math.max(left[k - 1], dp[i - 1][k] + k);
            }
            
            long[] right = new long[m];
            right[m - 1] = dp[i - 1][m - 1] - (m - 1);
            for(int k = m - 2; k >= 0; k--){
                right[k] = Math.max(right[k + 1], dp[i - 1][k] - k);
            }
            
            for(int j = 0; j < m; j++){
                dp[i][j] = Math.max(left[j] - j, right[j] + j) + points[i][j];
            }
        }
        
        long value = 0;
        for(int j = 0; j < m; j++){
            value = Math.max(value, dp[n - 1][j]);
        }
        
        return value;
    }
}