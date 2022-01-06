class Solution {
    public String decodeString(String s) {
        char[] decode = s.toCharArray();
        Stack<StringBuilder> strings = new Stack<StringBuilder>();
        Stack<Integer> count = new Stack<Integer>();
        int currCount = 0;
        StringBuilder currString = new StringBuilder();

        for(int i = 0; i < decode.length; i++){
            if(Character.isDigit(decode[i])){
                currCount = currCount * 10 + decode[i] - '0';
            }
            else if(decode[i] == '['){
                strings.push(currString);
                count.push(currCount);
                currString = new StringBuilder();
                currCount = 0;
            }
            else if(decode[i] == ']'){
                StringBuilder temp = strings.pop();
                for(int j = count.pop(); j > 0; j--){
                    temp.append(currString);
                }
                currString = temp;
            }
            else{
                currString.append(decode[i]);
            }
        }
        return currString.toString();
    }
}
