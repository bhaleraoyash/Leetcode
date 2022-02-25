class Solution {
    public String convert(String s, int numRows) {
        List<StringBuilder> sbList = new ArrayList<StringBuilder>();
        char[] chars = s.toCharArray();
        StringBuilder answer = new StringBuilder();
        
        if(numRows == 1){
            return s;
        }
        
        for(int i = 0; i < Math.min(s.length(), numRows); i++){
            sbList.add(new StringBuilder());
        }
        
        int index = 0;
        boolean goingDown = false;
        
        for(int i = 0; i < chars.length; i++){
            StringBuilder temp = sbList.get(index);
            temp.append(chars[i]);
            if(index == 0 || index == numRows - 1){
                goingDown = !goingDown;
            }
            index += goingDown ? 1 : -1;
        }
        
        for(StringBuilder sb : sbList){
            answer.append(sb);
        }
        
        return answer.toString();
    }
}