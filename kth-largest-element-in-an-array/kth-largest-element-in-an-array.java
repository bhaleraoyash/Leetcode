class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        
        for(Integer n : nums){
            minHeap.add(n);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        
        return minHeap.poll();
    }
}
