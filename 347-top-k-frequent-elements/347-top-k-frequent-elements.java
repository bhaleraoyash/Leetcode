class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] answer = new int[k];
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>((a,b) -> a[1] - b[1]);
        
        for(int i = 0; i < nums.length; i++){
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }
        
        for(Map.Entry<Integer,Integer> entry : count.entrySet()){
            int[] current = {entry.getKey(), entry.getValue()};  
            if(heap.size() < k){
                heap.add(current);
            }
            else{
                if(heap.peek()[1] < current[1]){
                    heap.poll();
                    heap.add(current);
                }
            }
        }
        
        int i = 0;
        while(!heap.isEmpty()){
            answer[i] = heap.poll()[0];
            i++;
        }
        
        return answer;
    }
}