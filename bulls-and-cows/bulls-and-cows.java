class Solution{
		public String getHint(String secret, String guess){
			Map<Character, Integer> indices = new HashMap<Character, Integer>();
			
			for(int i = 0; i < secret.length(); i++){
				char c = secret.charAt(i);
				indices.put(c, indices.getOrDefault(c, 0) + 1);
			}
			
			int cows = 0;
			int bulls = 0;
			
			for(int i = 0; i < guess.length(); i++){
				char c = guess.charAt(i);
				if(indices.containsKey(c)){
					if(c == secret.charAt(i)){
						bulls++;
						if(indices.get(c) <= 0){
							cows--;
						}
					}
					else{
						if(indices.get(c) > 0){
							cows++;
						}
					}
					indices.put(c, indices.get(c) - 1);
				}
			}
		return Integer.toString(bulls) + "A" + Integer.toString(cows) + "B";
		}
}
