class Solution {
    public int[] findBuildings(int[] heights) {
        List<Integer> list = new ArrayList<Integer>();
        
        for(int i = 0; i < heights.length; i++){
            while(!list.isEmpty() && heights[list.get(list.size() - 1)] <= heights[i]){
                list.remove(list.size() - 1);
            }
            list.add(i);
        }
        
        int answer[] = new int[list.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}