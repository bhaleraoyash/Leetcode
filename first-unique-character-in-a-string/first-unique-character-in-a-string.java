class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> counter = new HashMap<Character, Integer>();
        int answer = -1;

        for(int i = s.length() - 1; i >= 0; i--){
            char c = s.charAt(i);
            if(counter.containsKey(c)){
                counter.put(c, counter.get(c) + 1);
            }
            else{
                counter.put(c, 1);
            }
        }
        
        for(int i = s.length() - 1; i >= 0; i--){
            char c = s.charAt(i);
            if(counter.get(c) == 1){
                answer = i;
            }
        }
        return answer;        
    }
}
