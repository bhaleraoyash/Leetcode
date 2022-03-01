class Solution {
    public int[] countBits(int n) {
	    int[] answer = new int[n + 1];

        for(int i = 0; i <= n; i++){
        int count = decimalToBinary(i);
        answer[i] = count;
        }
        return answer;
    }

    public int decimalToBinary(int n){
        int[] binary = new int[10000];
        int i = 0;
        int count = 0;

        while(n > 0){
            binary[i] = n % 2;
            if(n % 2 == 1){
                count++;
            }
            n = n / 2;
            i++;
        }
        return count;
    }
}
