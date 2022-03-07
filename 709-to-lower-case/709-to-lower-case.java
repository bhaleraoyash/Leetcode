class Solution {
    public String toLowerCase(String s) {
        String answer = "";
        
        for(int i = 0; i < s.length(); i++){
            String temp = s.charAt(i) + "";
            String curr = temp.toLowerCase();
            answer += curr;
        }
        
        return answer;
    }
}