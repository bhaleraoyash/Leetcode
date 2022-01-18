class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n - 1){
            return false;
        }
        
        UnionFind uf = new UnionFind(n);
        for(int[] edge : edges){
            if(!uf.union(edge[0], edge[1])){
                return false;
            }
        }
        return true;
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

    public boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) {
            return false;
        }
        root[rootX] = rootY;
        return true;
    }
    
    public int[] returnRoot(){
        return root;
    }
}
