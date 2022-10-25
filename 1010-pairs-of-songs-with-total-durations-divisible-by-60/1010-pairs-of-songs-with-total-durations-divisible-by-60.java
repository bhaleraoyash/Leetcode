class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> remainder = new HashMap<Integer, Integer>();
        int answer = 0;
        
        for(int i = 0; i < time.length; i++){
            int rem1 = time[i] % 60;
            int rem2 = 60 - rem1;
            if(rem1 == 0 && remainder.containsKey(0)){
                answer += remainder.get(rem1);
            }
            if(remainder.containsKey(rem2)){
                answer += remainder.get(rem2);
            }
            remainder.put(rem1, remainder.getOrDefault(rem1, 0) + 1);
        }
        
        System.out.println(remainder);
        
        return answer;
    }
}