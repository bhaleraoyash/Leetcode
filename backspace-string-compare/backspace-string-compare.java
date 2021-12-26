class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stringS = new Stack<Character>();
        Stack<Character> stringT = new Stack<Character>();

        for(int i = 0; i < s.length(); i++){
        char c = s.charAt(i);
        if(c == '#' && !stringS.isEmpty()){
            stringS.pop();
        }
        else if(c!= '#'){
            stringS.push(c);
            }
        }

        for(int i = 0; i < t.length(); i++){
        char c = t.charAt(i);
        if(c == '#' && !stringT.isEmpty()){
            stringT.pop();
        }
        else if(c != '#'){
            stringT.push(c);
            }
        }

        System.out.println(stringS);
        System.out.println(stringT);
        return stringS.equals(stringT);       
    }
}
