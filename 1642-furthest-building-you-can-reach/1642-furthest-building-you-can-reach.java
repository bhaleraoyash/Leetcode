class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        int answer = heights.length - 1;
        
        for(int i = 0; i < heights.length - 1; i++){
            int current = heights[i];
            int next = heights[i + 1];
            if(current < next){
                heap.add(next - current);
                if(heap.size() > ladders){
                    int temp = heap.poll();
                    if(bricks >= temp){
                        bricks -= temp;
                    }
                    else{
                        answer = i;
                        break;
                    }
                }
            }
        }
        
        return answer;
    }
}