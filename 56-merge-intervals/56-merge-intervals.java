class Solution{
	public int[][] merge(int[][] intervals){
        if(intervals.length <= 1){
            return intervals;
        }
        
		List<int[]> result = new ArrayList<int[]>();
		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        int[] current_interval = intervals[0];
        result.add(current_interval);
		
		for(int i = 1; i < intervals.length; i++){
            int current_begin = current_interval[0];
            int current_end = current_interval[1];
            int next_begin = intervals[i][0];
            int next_end = intervals[i][1];
			if(current_end >= next_begin){
				current_interval[1] = Math.max(current_end, next_end);
			}
            else{
                current_interval = intervals[i];
                result.add(intervals[i]);
            }
		}
		return result.toArray(new int[result.size()][]);
	}
}
