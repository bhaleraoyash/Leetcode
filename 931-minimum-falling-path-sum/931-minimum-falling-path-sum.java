class Solution{
	public int minFallingPathSum(int[][] matrix){
		int n = matrix.length;
		int m = matrix[0].length;
		int[][] dp = new int[n][m];
		int answer = Integer.MAX_VALUE;

		for(int j = 0; j < m; j++){
			dp[0][j] = matrix[0][j];
		}

		for(int i = 1; i < n; i++){
			for(int j = 0; j < m; j++){
				if(j == 0){
					dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j + 1]) + matrix[i][j];
				}
				else if(j == m - 1){
					dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + matrix[i][j];
				}
				else{
					dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j + 1])) + matrix[i][j];
				}
			}
		}

		for(int j = 0; j < m; j++){
			answer = Math.min(answer, dp[n - 1][j]);
		}
		return answer;
	}
}
