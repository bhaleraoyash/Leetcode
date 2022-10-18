class Solution{
	public boolean checkIfPangram(String sentence){
		Set<Character> chars = new HashSet<Character>();

		for(int i = 0; i < sentence.length(); i++){
			char c = sentence.charAt(i);
			if(Character.isLetter(c)){
				chars.add(c);
			}
		}

		return chars.size() == 26;
	}
}
