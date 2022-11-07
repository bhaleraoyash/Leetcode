class Solution {
    public int numIslands(char[][] grid) {
        int answer = 0;
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == '1'){
                    answer++;
                    convertIsland(grid, i, j);
                }
            }
        }
        
        return answer;
    }
    
    public void convertIsland(char[][] grid, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0'){
            return;
        }
        
        grid[i][j] = '0';
        
        convertIsland(grid, i - 1, j);
        convertIsland(grid, i + 1, j);
        convertIsland(grid, i, j - 1);
        convertIsland(grid, i, j + 1);
    }
}