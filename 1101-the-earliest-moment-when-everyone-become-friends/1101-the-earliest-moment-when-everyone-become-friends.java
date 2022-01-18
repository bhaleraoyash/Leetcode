class Solution {
    public int earliestAcq(int[][] logs, int n) {
        int[] root = new int[n];
        
        Arrays.sort(logs, (a,b) -> a[0] - b[0]);
            
        for(int i = 0; i < root.length; i++){
            root[i] = i;
        }
        
        for(int[] edge : logs){
            union(edge[1], edge[2], root);
            if(checkConnected(root, n)){
                return edge[0];
            }
        }
        
        return -1;
        
    }
    
    public boolean checkConnected(int[] root, int n){
        Set<Integer> components = new HashSet<Integer>();
        
        for(int i = 0; i < root.length; i++){
            components.add(find(i, root));
        }
        
        return components.size() == 1;
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