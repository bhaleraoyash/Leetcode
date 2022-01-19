class Solution {
    public int numPairsDivisibleBy60(int[] time) { 
        Map<Integer, Integer> remCounter = new HashMap<Integer, Integer>();
        int answer = 0;
        
        for(int i = 0; i < time.length; i++){
            int rem = time[i] % 60;
            int diff = 60 - rem;
            if(rem == 0 && remCounter.containsKey(0)){
                answer += remCounter.get(0);
            }
            else if(remCounter.containsKey(diff)){
                answer += remCounter.get(diff);
            }
            remCounter.put(rem, remCounter.getOrDefault(rem, 0) + 1);
        }
        
        return answer;
    }
}