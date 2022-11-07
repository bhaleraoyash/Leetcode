class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> index = new HashMap<Character, Integer>();
        int answer = 0;
        int current = 0;
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(!index.containsKey(c)){
                index.put(c, i);
                current++;
            }
            else{
                int temp = index.get(c);
                index.clear();
                i = temp;
                current = 0;
            }
            answer = Math.max(answer, current);
        }
        
        return answer;
    }
}