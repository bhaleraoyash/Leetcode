class Solution {
    public int maximumWealth(int[][] accounts) {
        Map<Integer, Integer> wealth = new HashMap<Integer, Integer>();
        int answer = 0;
        
        for(int i = 0; i < accounts.length; i++){
            int sum = 0;
            for(int j = 0; j < accounts[i].length; j++){
                sum += accounts[i][j];
            }
            wealth.put(i, sum);
        }
        
        for(Integer current : wealth.values()){
            if(current > answer){
                answer = current;
            }
        }
        return answer;
    }
}