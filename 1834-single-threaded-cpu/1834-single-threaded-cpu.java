class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        Task[] arr = new Task[n];
        
        for(int i = 0; i < n; i++){
            arr[i] = new Task(i, tasks[i][0], tasks[i][1]);
        }
        
        Arrays.sort(arr, (a, b) -> {
            return Integer.compare(a.enqueueTime, b.enqueueTime);
        });
        
        PriorityQueue<Task> heap = new PriorityQueue<Task>((a, b) -> {
            if(a.processingTime == b.processingTime){
                return Integer.compare(a.index, b.index);
            }
            return Integer.compare(a.processingTime, b.processingTime);
        });
        
        int[] ans = new int[n];
        int ansIndex = 0;
        int taskIndex = 0;
        int currentTime = 0;
        
        while(ansIndex < n){
            while(taskIndex < n && arr[taskIndex].enqueueTime <= currentTime){
                heap.offer(arr[taskIndex++]);
            }
            if(heap.isEmpty()){
                currentTime = arr[taskIndex].enqueueTime;
            }
            else{
                currentTime += heap.peek().processingTime;
                ans[ansIndex++] = heap.poll().index;
            }
        }
        return ans;
    }
}

class Task{
    int index;
    int enqueueTime;
    int processingTime;
    
    Task(int index, int enqueueTime, int processingTime){
        this.index = index;
        this.enqueueTime = enqueueTime;
        this.processingTime = processingTime;
    }
}