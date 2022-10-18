class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> chars = new HashMap<Character, Integer>();
        int answer = 0;
        int count = 0;
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(!chars.containsKey(c)){
                chars.put(c, i);
                count += 1;
            }
            else{
                int temp = chars.get(c);
                chars.clear();
                count = 0;
                i = temp;
            }
            answer = Math.max(answer, count);
        }
        
        return answer;
    }
}