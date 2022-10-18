class Solution{
	public boolean isValid(String s){
        Stack<Character> stack = new Stack<Character>();
        Map<Character, Character> brackets = new HashMap<Character, Character>();
        brackets.put('}', '{');
        brackets.put(')', '(');
        brackets.put(']', '[');

		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }
            else if(brackets.containsKey(c) && !stack.isEmpty() && brackets.get(c) == stack.peek()){
                stack.pop();
            }
            else{
                return false;
            }
        }
        
        return stack.isEmpty();
    }
}