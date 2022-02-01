class Solution{
	public int[][] kClosest(int[][] points, int k){
		PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>((a, b) -> b[1] - a[1]);
		int[][] answer = new int[k][2];

		for(int i = 0; i < points.length; i++){
			int distance = calculateDistance(points[i][0], points[i][1]);
            maxHeap.add(new int[]{i, distance});
			if(maxHeap.size() > k){
                maxHeap.poll();
			}
		}

		int i = 0;
		while(!maxHeap.isEmpty()){
			int[] temp = maxHeap.poll();
			answer[i] = points[temp[0]];
			i++;
		}
		return answer;
	}

	public int calculateDistance(int x2, int y2){
		int x1 = 0;
		int y1 = 0;
		int x = x2 - x1;
		int y = y2 - y1;
		return (x * x) + (y * y);
	}
}
