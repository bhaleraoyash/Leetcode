class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>((a,b) -> b[0] - a[0]);
        int[][] answer = new int[k][2];
        
        for(int i = 0; i < points.length; i++){
            int x = points[i][0];
            int y = points[i][1];
            int distance = (x * x) + (y * y);
            int[] temp = new int[]{distance, i};
            maxHeap.add(temp);
            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }
        
        int i = 0;
        while(!maxHeap.isEmpty()){
            int[] top = maxHeap.poll();
            int[] temp = points[top[1]];
            answer[i++] = temp;
        }
        
        return answer;
    }
}