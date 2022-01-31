class Solution{
	public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location){
		List<Double> angles = new ArrayList<Double>();
		int count = 0;

		for(List<Integer> point : points){
			int dx = point.get(0) - location.get(0);
			int dy = point.get(1) - location.get(1);

			if(dx == 0 && dy == 0){
				count++;
				continue;
			}

			angles.add(Math.atan2(dy, dx) * (180 / Math.PI));
		}

		Collections.sort(angles);
		int res = count;
		List<Double> temp = new ArrayList<Double>(angles);
		for(Double d : angles){
			temp.add(d + 360);
		}
			
		int j = 0;
		for(int i = 0; i < temp.size(); i++){
			while(temp.get(i) - temp.get(j) > angle){
				j++;
			}
			res = Math.max(res, count + i - j + 1);
		}
		return res;
	}
}
