class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int answer = 0;
        int current = startFuel;
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((a, b) -> b - a);
        
        for(int[] station : stations){
            int nextStation = station[0];
            int fuelAtStation = station[1];
            
            while(current < nextStation){
                if(heap.isEmpty()){
                    return -1;
                }
                int maxFuel = heap.poll();
                current += maxFuel;
                answer++;
            }
            heap.add(fuelAtStation);
        }
        
        while(current < target){
            if(heap.isEmpty()){
                return -1;
            }
            int maxFuel = heap.poll();
            current += maxFuel;
            answer++;
        }
        
        return answer;
    }
}