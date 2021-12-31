class Solution{
	public int lengthOfLongestSubstring(String s){
		Set<Character> sub = new HashSet<Character>();
		Map<Character, Integer> index = new HashMap<Character, Integer>();
		char[] chars = s.toCharArray();
		int count = 0;
		int answer = 0;

		for(int i = 0; i < chars.length; i++){
			if(!index.containsKey(chars[i])){
				index.put(chars[i], i);
				count++;
			}
			else{
				i = index.get(chars[i]) + 1;
				index.clear();
				index.put(chars[i], i);
				count = 1;
			}
			answer = Math.max(answer, count);
		}
		return answer;
	}
}
