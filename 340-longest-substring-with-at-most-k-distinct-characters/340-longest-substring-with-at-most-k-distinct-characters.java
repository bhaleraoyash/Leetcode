class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> index = new HashMap<Character, Integer>();
        int left = 0;
        int right = 0;
        int answer = 0;
        
        while(right < s.length()){
            char c = s.charAt(right);
            index.put(c, right);
            if(index.size() > k){
                int min = Collections.min(index.values());
                left = min + 1;
                index.remove(s.charAt(min));
            }
            answer = Math.max(answer, right - left + 1);
            right++;
        }
        return answer;
    }
}