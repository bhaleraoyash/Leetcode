class Solution{
	public String multiply(String num1, String num2){
		int[] sum = new int[num1.length() + num2.length()];
		String answer = "";

		if(num1.equals("0") || num2.equals("0")){
			return "0";
		}

		for(int i = num1.length() - 1; i >= 0; i--){
			char digit1 = num1.charAt(i);
			for(int j = num2.length() - 1; j >= 0; j--){
				char digit2 = num2.charAt(j);
				sum[i + j + 1] += (digit1 - '0') * (digit2 - '0');
				sum[i + j] += sum[i + j + 1] / 10;
				sum[i + j + 1] %= 10;
			}
		}

        int i = 0;
        while(sum[i] == 0){
            i++;
        }
		for(; i < sum.length; i++){
			answer += sum[i];
		}
		
		return answer;
	}
}
