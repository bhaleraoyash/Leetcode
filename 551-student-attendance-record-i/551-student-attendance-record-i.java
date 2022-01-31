class Solution {
    public boolean checkRecord(String s) {
        int countA = 0;
        int countL = 0;
        int n = s.length();
        
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            if(c == 'A'){
                countA++;
                if(countA >= 2){
                    return false;
                }
            }
            else if(c == 'L' && i <= n - 3){
                if(s.charAt(i + 1) == 'L' && s.charAt(i + 2) == 'L'){
                    return false;
                }
            }
        }
        
        return true;
    }
}