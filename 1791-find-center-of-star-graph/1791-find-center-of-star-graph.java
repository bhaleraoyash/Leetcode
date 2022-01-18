class Solution {
    public int findCenter(int[][] edges) {
        Map<Integer, Integer> counter = new HashMap<Integer, Integer>();
        int answer = 0;
        
        for(int[] edge : edges){
            counter.put(edge[0], counter.getOrDefault(edge[0], 0) + 1);
            counter.put(edge[1], counter.getOrDefault(edge[1], 0) + 1);
        }
        
        for(Map.Entry<Integer, Integer> entry : counter.entrySet()){
            if(entry.getValue() == edges.length){
                answer = entry.getKey(); 
                break;
            }
        }
        
        return answer;
    }
}