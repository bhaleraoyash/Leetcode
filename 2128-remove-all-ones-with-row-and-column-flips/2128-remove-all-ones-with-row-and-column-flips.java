class Solution {
    public boolean removeOnes(int[][] grid) {
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(Math.abs(grid[i][j] - grid[0][j]) != Math.abs(grid[i][0] - grid[0][0])){
                    return false;
                }
            }
        }
        return true;
    }
}