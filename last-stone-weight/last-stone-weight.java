class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((a, b) -> b - a);
        
        for(int i = 0; i < stones.length; i++){
            heap.add(stones[i]);
        }
        
        while(heap.size() > 1){
            int stone1 = heap.poll();
            int stone2 = heap.poll();
            if(stone1 != stone2){
                stone1 -= stone2;
                heap.add(stone1);
            }
        }
        
        return heap.size() == 1 ? heap.poll() : 0;
    }
}