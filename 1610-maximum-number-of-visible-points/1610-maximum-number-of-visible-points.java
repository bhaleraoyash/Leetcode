class Solution{
	public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location){
		List<Double> angles = new ArrayList<Double>();
		int count = 0;

		for(List<Integer> p : points){
			int dx = p.get(0) - location.get(0);
			int dy = p.get(1) - location.get(1);
			
			if(dx == 0 && dy == 0){
				count++;
				continue;
			}

			angles.add(Math.atan2(dy, dx) * (180 / Math.PI));
		}

		Collections.sort(angles);
		List<Double> temp = new ArrayList<Double>(angles);
		for(Double d : angles){
			temp.add(d + 360);
		}
		
		int j = 0;
        int answer = count;
        
		for(int i = 0; i < temp.size(); i++){
			while(temp.get(i) - temp.get(j) > angle){
				j++;
			}
			answer = Math.max(answer, count + i - j + 1);
		}
		return answer;
	}
}
