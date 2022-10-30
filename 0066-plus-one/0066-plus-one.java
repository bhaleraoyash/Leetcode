class Solution {
    public int[] plusOne(int[] digits) {
        int[] answer = new int[digits.length + 1];
        
        for(int i = digits.length - 1; i >= 0; i--){
            if(digits[i] < 9){
                digits[i] += 1;
                return digits;
            }
            digits[i] = 0;
        }
        
        answer[0] = 1;
        for(int i = 1; i < answer.length; i++){
            answer[i] = digits[i - 1];
        }
        
        return answer;
    }
}