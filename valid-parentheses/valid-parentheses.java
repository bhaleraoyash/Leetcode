class Solution {
    public boolean isValid(String s) {
        Stack<Character> brackets = new Stack<Character>();
        char[] characters = s.toCharArray();
        
        for(int i = 0; i < characters.length; i++){
            if(characters[i] == '{' || characters[i] == '[' || characters[i] == '('){
                brackets.push(characters[i]);
            }
            else if(!brackets.isEmpty()){
                char c = brackets.peek();
                if(!brackets.isEmpty() && characters[i] == '}' && c == '{'){
                    brackets.pop();
                }
                else if(!brackets.isEmpty() && characters[i] == ']' && c == '['){
                    brackets.pop();
                }
                else if(!brackets.isEmpty() && characters[i] == ')' && c == '('){
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