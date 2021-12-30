class Solution{
	public int numJewelsInStones(String jewels, String stones){
		int answer = 0;
		Set<Character> jewelSet = new HashSet<Character>();

		for(char c : jewels.toCharArray()){
			jewelSet.add(c);
		}
		
		for(int i = 0; i < stones.length(); i++){
			char c = stones.charAt(i);
			if(jewelSet.contains(c)){
				answer++;
			}
		}
        return answer;
	}
}
