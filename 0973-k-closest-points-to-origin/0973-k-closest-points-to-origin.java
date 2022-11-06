class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair<int[], Integer>> heap = new PriorityQueue<Pair<int[], Integer>>((a, b) -> b.getValue() - a.getValue());
        
        for(int i = 0; i < points.length; i++){
            int distance = calculateDistance(points[i]);
            Pair<int[], Integer> temp = new Pair<int[], Integer>(points[i], distance);
            heap.add(temp);
            if(heap.size() > k){
                heap.poll();
            }
        }
        
        int[][] answer = new int[heap.size()][2];
        int index = 0;
        
        while(!heap.isEmpty()){
            answer[index] = heap.poll().getKey();
            index++;
        }
        
        return answer;
    }
    
    public int calculateDistance(int[] point){
        int  x = point[0] * point[0];
        int  y = point[1] * point[1];
        
        return x + y;
    }
}