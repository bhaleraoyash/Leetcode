class Solution {
    public int[] getOrder(int[][] tasks) {
        PriorityQueue<int[]> allTasks = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
        PriorityQueue<int[]> possibleTasks = new PriorityQueue<int[]>((a, b) -> a[2] == b[2] ? a[0] - b[0] : a[2] - b[2]);
        int[] answer = new int[tasks.length];
        
        for(int i = 0; i < tasks.length; i++){
            allTasks.add(new int[]{i, tasks[i][0], tasks[i][1]});
        }
        
        int currentTime = -1;
        int pointer = 0;
        
        while(allTasks.size() > 0 || possibleTasks.size() > 0){
            if(allTasks.size() > 0 && possibleTasks.size() == 0 && currentTime < allTasks.peek()[1]){
                currentTime = allTasks.peek()[1];
            }
            
            while(allTasks.size() > 0 && currentTime >= allTasks.peek()[1]){
                possibleTasks.add(allTasks.poll());
            }
            
            int[] task = possibleTasks.poll();
            currentTime += task[2];
            answer[pointer++] = task[0];
        }
        return answer;
    }
}