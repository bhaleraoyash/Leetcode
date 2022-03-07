class Solution {
    public boolean isValid(String s) {
        Stack<Character> brackets = new Stack<Character>();
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '{' || c == '[' || c == '('){
                brackets.push(c);
            }
            else if(!brackets.isEmpty()){
                if(c == '}' && brackets.peek() == '{'){
                    brackets.pop();
                }
                else if(c == ')' && brackets.peek() == '('){
                    brackets.pop();
                }
                else if(c == ']' && brackets.peek() == '['){
                    brackets.pop();
                }
                else{
                    return false;
                }
            }
            else{
                return false;
            }
        }
        
        return brackets.isEmpty();
    }
}