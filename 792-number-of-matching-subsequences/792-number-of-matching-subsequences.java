class Solution{
	public int numMatchingSubseq(String s, String[] words){
		Map<Character, Queue<String>> dict = new HashMap<Character, Queue<String>>();
		int answer = 0;

		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			dict.put(c, new LinkedList<String>());
		}

		for(int i = 0; i < words.length; i++){
			char c = words[i].charAt(0);
			if(dict.containsKey(c)){
				dict.get(c).add(words[i]);
			}
		}

		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			Queue<String> temp = dict.get(c);
			int size = temp.size();
			for(int j = 0; j < size; j++){
				String s1 = temp.poll();
				String shortened = s1.substring(1);
				if(shortened.length() == 0){
					answer++;
				}
				else{
					char c1 = shortened.charAt(0);
					if(dict.containsKey(c1)){
						dict.get(c1).add(shortened);
					}
				}
			}
		}

		return answer;
	}
}
