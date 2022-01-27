class Solution {
    public int longestStrChain(String[] words) {
        Map<String, Integer> dp = new HashMap<String, Integer>();
        int answer = 0;
        
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        
        for(String word : words){
            int longestChain = 0;
            for(int i = 0; i < word.length(); i++){
                String predecessor = word.substring(0, i) + word.substring(i + 1, word.length());
                longestChain = Math.max(longestChain, dp.getOrDefault(predecessor, 0) + 1);
            }
            dp.put(word, longestChain);
            answer = Math.max(answer, longestChain);
        }
        
        return answer;
    }
}