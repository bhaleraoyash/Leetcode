class Solution{
	public int[][] merge(int[][] intervals){
		List<int[]> answer = new ArrayList<int[]>();

		Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));

		int[] current_interval = intervals[0];
		answer.add(current_interval);

		for(int[] i : intervals){
			int current_begin = current_interval[0];
			int current_end  = current_interval[1];
			int next_begin = i[0];
			int next_end = i[1];

			if(current_end >= next_begin){
				current_interval[1] = Math.max(current_end, next_end);
			}
			else{
				current_interval = i;
				answer.add(current_interval);
			}
		}

		return answer.toArray(new int[answer.size()][]);
	}
}