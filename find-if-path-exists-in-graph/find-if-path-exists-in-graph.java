class Solution {
    public boolean validPath(int n, int[][] edges, int start, int end) {
        int[] root = new int[n];
        
        for(int i = 0; i < root.length; i++){
            root[i] = i;
        }
        
        for(int i = 0; i < edges.length; i++){
            union(edges[i][0], edges[i][1], root);
        }
        
        return find(start, root) == find(end, root);
    }
    
    public void union(int edge1, int edge2, int[] root){
        int parent1 = find(edge1, root);
        int parent2 = find(edge2, root);
        root[parent1] = parent2;
    }
    
    public int find(int node, int[] root){
        if(root[node] != node){
            root[node] = find(root[node], root);
        }
        return root[node];
    }
}