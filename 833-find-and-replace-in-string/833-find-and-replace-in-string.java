class Solution{
	public String findReplaceString(String s, int[] indices, String[] sources, String[] targets){
		int n = s.length();
		int[] match = new int[n];
		StringBuilder answer = new StringBuilder();
        
        Arrays.fill(match, -1);

		for(int i = 0; i < indices.length; i++){
			if(s.substring(indices[i], indices[i] + sources[i].length()).equals(sources[i])){
				match[indices[i]] = i;
			}
		}

		int index = 0;
		while(index < n){
			if(match[index] >= 0){
				answer.append(targets[match[index]]);
                index += sources[match[index]].length();
			}
			else{
				answer.append(s.charAt(index++));
			}
		}

		return answer.toString();
	}
}
