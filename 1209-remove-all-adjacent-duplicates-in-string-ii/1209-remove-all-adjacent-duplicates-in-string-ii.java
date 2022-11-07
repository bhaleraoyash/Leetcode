class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair<Character, Integer>> stack = new Stack<Pair<Character, Integer>>();
        String answer = "";
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(stack.isEmpty()){
                Pair<Character, Integer> temp = new Pair<Character, Integer>(c, 1);
                stack.push(temp);
            }
            else{
                if(stack.peek().getKey() == c){
                    Pair<Character, Integer> temp1 = stack.pop();
                    Pair<Character, Integer> temp2 = new Pair<Character, Integer>(c, temp1.getValue() + 1);
                    if(temp2.getValue() < k){
                        stack.push(temp2);
                    }
                }
                else{
                    Pair<Character, Integer> temp = new Pair<Character, Integer>(c, 1);
                    stack.push(temp);
                }
            }
        }
        
        while(!stack.isEmpty()){
            Pair<Character, Integer> temp = stack.pop();
            String str = String.valueOf(temp.getKey());
            String current = str.repeat(temp.getValue());
            answer = current + answer;
        }
        
        return answer;
    }
}
