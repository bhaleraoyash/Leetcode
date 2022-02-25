class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int distance = Integer.MAX_VALUE;
        int answer = -1;
        
        for(int i = 0; i < points.length; i++){
            if(points[i][0] == x || points[i][1] == y){
                int manhattan = Math.abs(points[i][0] - x) + Math.abs(points[i][1] - y);
                if(manhattan < distance){
                    answer = i;
                    distance = manhattan;
                }
                else if(manhattan == distance){
                    answer = Math.min(answer, i);
                    distance = manhattan;
                }
            }
        }
        return answer;
    }
}