class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> brackets = new HashMap<Character, Character>();
        Stack<Character> stack = new Stack<Character>();
        brackets.put('}', '{');
        brackets.put(')', '(');
        brackets.put(']', '[');
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(!brackets.containsKey(c)){
                stack.push(c);
            }
            else{
                if(!stack.isEmpty() && stack.peek() == brackets.get(c)){
                    stack.pop();
                }
                else{
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
}