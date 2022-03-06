class Solution {
    public boolean checkString(String s) {
        boolean flag = false;
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == 'a' && flag == true){
                return false;
            }
            else if(c == 'b'){
                flag = true;
            }
        }
        
        return true;
    }
}