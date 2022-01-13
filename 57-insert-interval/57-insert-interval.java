class Solution{
	public int[][] insert(int[][] intervals, int[] newInterval){
		int newStart = newInterval[0];
        int newEnd = newInterval[1];
        int idx = 0;
        int n = intervals.length;
        List<int[]> output = new ArrayList<int[]>();
        
        while (idx < n && intervals[idx][1] < newStart)
          output.add(intervals[idx++]);
        
        int[] interval = new int[2];
        while(idx < n && intervals[idx][0] <= newEnd)
        {
            newStart = Math.min(newStart, intervals[idx][0]);
            newEnd = Math.max(newEnd, intervals[idx][1]);
            ++idx;
        }   
        output.add(new int[]{newStart, newEnd});
 
        while (idx < n)
          output.add(intervals[idx++]);

        return output.toArray(new int[0][0]);
	}
}
