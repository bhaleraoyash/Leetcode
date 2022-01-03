class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> index = new HashMap<Character, Integer>();
        char[] chars = s.toCharArray();
        int answer = 0;
        int left = 0;
        int right = 0;
        
        while(right < chars.length){
            index.put(chars[right], right);
            if(index.size() > k){
                int i = Collections.min(index.values());
                index.remove(chars[i]);
                left = i + 1;
            }
            answer = Math.max(answer, right - left + 1);
            right++;
        }
        return answer;
    }
}