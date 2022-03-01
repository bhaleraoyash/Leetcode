class Solution {
    public int[] countBits(int n) {
        int[] answer = new int[n + 1];
        answer[0] = 0;
        
        for(int i = 1; i <= n; i++){
            answer[i] = countOnes(i);
        }
        
        return answer;
    }
    
    public int countOnes(int n){
        int answer = 0;
        
        while(n > 0){
            int temp = n % 2;
            if(temp == 1){
                answer++;
            }
            n /= 2;
        }
        
        return answer;
    }
}