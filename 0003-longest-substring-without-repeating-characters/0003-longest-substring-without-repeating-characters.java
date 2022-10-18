class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> chars = new HashSet<Character>();
        int left = 0;
        int right = 0;
        int answer = 0;
        
        while(right < s.length()){
            char c = s.charAt(right);
            if(!chars.contains(c)){
                chars.add(c);
                right++;
                answer = Math.max(answer, chars.size());
            }
            else{
                chars.remove(s.charAt(left));
                left++;
            }
        }
        
        return answer;
    }
}