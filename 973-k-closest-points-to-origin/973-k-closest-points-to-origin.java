class Solution{
	public int[][] kClosest(int[][] points, int k){
        int[][] answer = new int[k][2];
        
		PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        
        for(int i = 0; i < points.length; i++){
            int[] entry = {distance(points[i]), i};
            if(heap.size() < k){
                heap.add(entry);
            }
            else{
                if(entry[0] < heap.peek()[0]){
                    heap.poll();
                    heap.add(entry);
                }
            }
        }
        
        int i = 0;
        while(!heap.isEmpty()){
            answer[i] = points[heap.poll()[1]];
            i++;
        }
        return answer;
	}
    
    public int distance(int[] coords){
        int x1 = 0;
        int y1 = 0;
    
        int x = (coords[0] - x1) * (coords[0] - x1);
        int y = (coords[1] - y1) * (coords[1] - y1);
        
        return x + y;
    }
}
