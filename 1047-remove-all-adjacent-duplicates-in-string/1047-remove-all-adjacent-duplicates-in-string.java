class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<Character>();
        String answer = "";
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(stack.isEmpty()){
                stack.push(c);
            }
            else{
                if(stack.peek() == c){
                    stack.pop();
                }
                else{
                    stack.push(c);
                }
            }
        }
        
        while(!stack.isEmpty()){
            String str = String.valueOf(stack.pop());
            answer = str + answer;
        }
        
        return answer;
    }
}