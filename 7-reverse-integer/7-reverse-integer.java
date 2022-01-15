class Solution {
    public int reverse(int x) {
        int answer = 0;
        
        while(x != 0){
            int mod = x % 10;
            x /= 10;
            if(answer > Integer.MAX_VALUE / 10 || answer < Integer.MIN_VALUE / 10){
                return 0;
            }
            answer = answer * 10 + mod;
        }
        return answer;
    }
}