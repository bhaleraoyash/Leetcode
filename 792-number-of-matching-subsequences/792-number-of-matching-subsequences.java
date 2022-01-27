class Solution{
	public int numMatchingSubseq(String s, String[] words){
		Map<Character, Queue<String>> dict = new HashMap<Character, Queue<String>>();
        int answer = 0;

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            dict.putIfAbsent(c, new LinkedList());
        }
        
		for(int i = 0; i < words.length; i++){
			char c = words[i].charAt(0);
			if(dict.containsKey(c)){
				dict.get(c).add(words[i]);
			}
		}

		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
            Queue<String> q = dict.get(c);
            int size = q.size();
            for(int j = 0; j < size; j++){
                String str = q.poll();
                if(str.substring(1).length() == 0){
                    answer++;
                }
                else{
                    if(dict.containsKey(str.charAt(1))){
                        dict.get(str.charAt(1)).add(str.substring(1));
                    }
                }
            }
		}

		return answer;
	}
}
