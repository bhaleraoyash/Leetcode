class Solution{
	public String decodeString(String s){
		Stack<Integer> counter = new Stack<Integer>();
		Stack<StringBuilder> strings = new Stack<StringBuilder>();
		int currentCount = 0;
		StringBuilder currentString = new StringBuilder();
		

		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			if(Character.isDigit(c)){
				currentCount = currentCount * 10 + c - '0';
			}
			else if(c == '['){
				counter.push(currentCount);
				strings.push(currentString);
				currentCount = 0;
				currentString = new StringBuilder();
			}
			else if(c == ']'){
				StringBuilder temp = strings.pop();
				for(int j = counter.pop(); j > 0; j--){
					temp.append(currentString);
				}
				currentString = temp;
			}
			else{
				currentString.append(c);
			}
		}
		return currentString.toString();
	}
}
