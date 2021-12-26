class Solution {
    public int findJudge(int n, int[][] trust) {
        Map<Integer, Integer> votes = new HashMap<Integer, Integer>();
        Set<Integer> voters = new HashSet<Integer>();
        if(n == 1){
            return 1;
        }
        
        for(int i = 0; i < trust.length; i++){
            votes.put(trust[i][1], votes.getOrDefault(trust[i][1], 0) + 1);
            voters.add(trust[i][0]);
        }
        
        for(Integer i : votes.keySet()){
            if(votes.get(i) == n - 1 && !voters.contains(i)){
                return i;
            }
        }
        return -1;
    }
}