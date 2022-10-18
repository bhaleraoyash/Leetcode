class Solution{
	public int numIslands(char[][] grid){
		int answer = 0;

		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[i].length; j++){
				if(grid[i][j] == '1'){
					answer += 1;
					changeIsland(grid, i, j);
				}
			}
		}

		return answer;
	}

	public void changeIsland(char[][] grid, int i, int j){
		if(i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == '0'){
			return;
		}

		grid[i][j] = '0';
		changeIsland(grid, i - 1, j);
		changeIsland(grid, i + 1, j);
		changeIsland(grid, i, j - 1);
		changeIsland(grid, i, j + 1);
	}
}
