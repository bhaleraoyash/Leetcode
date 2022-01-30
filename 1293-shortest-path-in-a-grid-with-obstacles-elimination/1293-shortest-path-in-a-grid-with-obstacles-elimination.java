class Solution {
    public int shortestPath(int[][] grid, int k) {
        int[][] dir = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        int m = grid.length;
        int n = grid[0].length;
        
        if(m == 0 || n == 0){
            return 0;
        }
        
        int[][] obstacle = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<int[]>();
        
        queue.add(new int[]{0, 0, grid[0][0]});
        obstacle[0][0] = grid[0][0];
        
        int level = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                int[] head = queue.poll();
                if(head[0] == m - 1 && head[1] == n - 1){
                    return level - 1;
                }
                int currentObstacleCount = head[2];
                for(int[] d : dir){
                    int x = head[0] + d[0];
                    int y = head[1] + d[1];
                    if(!(x >= 0 && y >= 0 && x < m && y < n)){
                        continue;
                    }
                    int oldObstacleCount = obstacle[x][y];
                    int newObstacleCount = currentObstacleCount + grid[x][y];

                    if((!visited[x][y]) && newObstacleCount <= k){
                        queue.add(new int[]{x, y, newObstacleCount});
                        obstacle[x][y] = newObstacleCount;
                        visited[x][y] = true;
                    }

                    if(newObstacleCount < oldObstacleCount && newObstacleCount <= k){
                        queue.add(new int[]{x, y, newObstacleCount});
                        obstacle[x][y] = newObstacleCount;
                        visited[x][y] = true;
                    }
                }
            }
            level++;
        }
        return -1;
    }
}