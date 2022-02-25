class Solution{
	public int lengthOfLongestSubstring(String s){
		Map<Character, Integer> index = new HashMap<Character, Integer>();
        int count = 0;
        int answer = 0;
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(!index.containsKey(c)){
                index.put(c, i);
                count++;
            }
            else{
                i = index.get(c) + 1;
                index.clear();
                index.put(s.charAt(i), i);
                count = 1;
            }
            answer = Math.max(answer, count);
        }
        return answer;
	}
}
