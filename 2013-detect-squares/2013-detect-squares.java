class DetectSquares {
    
    List<int[]> points;
    Map<String, Integer> counter;
    
    public DetectSquares() {
        points = new ArrayList<int[]>();
        counter = new HashMap<String, Integer>();
    }
    
    public void add(int[] point) {
        points.add(point);
        String temp = point[0] + "@" + point[1];
        counter.put(temp, counter.getOrDefault(temp, 0) + 1);
    }
    
    public int count(int[] point) {
        int px = point[0];
        int py = point[1];
        int sum = 0;
        
        for(int[] p : points){
            int x = p[0];
            int y = p[1];
            if(px == x || py == y || Math.abs(px - x) != Math.abs(py - y)){
                continue;
            }
            sum += counter.getOrDefault(x + "@" + py, 0) * counter.getOrDefault(px + "@" + y, 0);
        }
        return sum;
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */