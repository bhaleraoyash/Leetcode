class Solution{
	public int[][] kClosest(int[][] points, int k){
		int x1 = 0;
		int y1 = 0;
        int[][] answer = new int[k][2];
		Map<Integer, Double> indexDistance = new HashMap<Integer, Double>();

		for(int i = 0; i < points.length; i++){
			int x2 = points[i][0];
			int y2 = points[i][1];
			int x = (x1 - x2) * (x1 - x2);
			int y = (y1 - y2) * (y1 - y2);
			double distance = Math.sqrt(x + y);
			indexDistance.put(i, distance);
		}
        
        List<Map.Entry<Integer, Double>> list =
               new LinkedList<Map.Entry<Integer, Double>>(indexDistance.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Double>>() {
            public int compare(Map.Entry<Integer, Double> o1,
                               Map.Entry<Integer, Double> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });
        HashMap<Integer, Double> temp = new LinkedHashMap<Integer, Double>();
        for (Map.Entry<Integer, Double> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }

        int count = 0;
        for(Map.Entry<Integer,Double> entry : temp.entrySet()){
            if(count < k){
                answer[count] = points[entry.getKey()];
                count++;
            }
        }
		return answer;
	}
}
