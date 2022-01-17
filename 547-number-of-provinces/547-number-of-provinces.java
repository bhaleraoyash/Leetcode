class Solution {
    public int findCircleNum(int[][] isConnected) {
        UnionFind uf = new UnionFind(isConnected.length);
        
        for(int i = 0; i < isConnected.length; i++){
            for(int j = 0; j < isConnected[i].length; j++){
                if(isConnected[i][j] == 1){
                    uf.union(i, j);
                }
            }
        }
        
        int count = 0;
        int[] root = uf.returnRoot();
        for(int i = 0; i < root.length; i++){
            if(i == root[i]){
                count++;
            }
        }
        
        return count;
    }
}

class UnionFind {
    private int[] root;

    public UnionFind(int size) {
        root = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
        }
    }

    public int find(int x) {
        if (x == root[x]) {
            return x;
        }
        return root[x] = find(root[x]);
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            root[rootY] = rootX;
        }
    }
    
    public int[] returnRoot(){
        return root;
    }
}