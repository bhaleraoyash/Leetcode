class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int answer = Integer.MAX_VALUE;
        
        for(int j = 0; j < n; j++){
            dp[0][j] = matrix[0][j];
        }
        
        for(int i = 1; i < m; i++){
            for(int j = 0; j < n; j++){
                if(j == 0){
                    dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j], dp[i - 1][j + 1]);
                }
                else if(j == n - 1){
                    dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
                }
                else{
                    dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j + 1]));
                }
            }
        }
        
        for(int j = 0; j < n; j++){
            if(dp[m - 1][j] < answer){
                answer = dp[m - 1][j];
            }
        }
        return answer;
    }
}