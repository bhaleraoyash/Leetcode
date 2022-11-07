class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length <= 1){
            return intervals;
        }
        List<int[]> answer = new ArrayList<int[]>();
        
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        int[] current_interval = intervals[0];
        answer.add(current_interval);
        
        for(int[] interval : intervals){
            int currentStart = current_interval[0];
            int currentEnd = current_interval[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];
            
            if(currentEnd >= nextStart){
                current_interval[1] = Math.max(currentEnd, nextEnd);
            }
            else{
                current_interval = interval;
                answer.add(current_interval);
            }
        }
        
        return answer.toArray(new int[answer.size()][]);
    }
}