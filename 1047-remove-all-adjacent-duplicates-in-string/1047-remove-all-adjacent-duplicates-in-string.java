class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<Character>();
        String answer = "";
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(!stack.isEmpty() && c == stack.peek()){
                stack.pop();
            }
            else{
                stack.push(c);
            }
        }
        
        while(!stack.isEmpty()){
            char c = stack.pop();
            answer = String.valueOf(c) + answer;
        }
        
        return answer;
    }
}