class Solution{
	public boolean isIsomorphic(String s, String t){
		if(s.length() != t.length()){
			return false;
		}

		char[] s1 = s.toCharArray();
		char[] t1 = t.toCharArray();
		Map<Character, Character> mapStoT = new HashMap<Character, Character>();
        Map<Character, Character> mapTtoS = new HashMap<Character, Character>();

		for(int i = 0; i < s1.length; i++){
			if(!mapStoT.containsKey(s1[i]) && !mapTtoS.containsKey(t1[i])){
				mapStoT.put(s1[i], t1[i]);
                mapTtoS.put(t1[i], s1[i]);
			}
            else if((mapStoT.containsKey(s1[i]) && !mapTtoS.containsKey(t1[i])) || (mapTtoS.containsKey(t1[i]) && !mapStoT.containsKey(s1[i])) ){
                return false;
            }
            else if(mapStoT.get(s1[i]) != t1[i] || mapTtoS.get(t1[i]) != s1[i]){
                return false;
            }
		}
       
		return true;
	}
}
