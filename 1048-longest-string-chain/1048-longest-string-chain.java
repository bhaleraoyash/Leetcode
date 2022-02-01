class Solution{
	public int longestStrChain(String[] words){
		Arrays.sort(words, (a, b) -> a.length() - b.length());

		Map<String, Integer> dp = new HashMap<String, Integer>();
		int answer = 0;

		for(String s : words){
			int longestChain = 0;
			for(int i = 0; i < s.length(); i++){
				String pred = s.substring(0, i) + s.substring(i + 1);
				longestChain = Math.max(longestChain, dp.getOrDefault(pred, 0) + 1);
			}
			dp.put(s, longestChain);
			answer = Math.max(answer, longestChain);
		}

		return answer;
	}
}
