class Solution{
	public String multiply(String num1, String num2){
		if(num1.equals("0") || num2.equals("0")){
			return "0";
		}

		String answer = "";
		int n = num1.length();
		int m = num2.length();
		int[] sum = new int[n + m];

		for(int i = n - 1; i >= 0; i--){
			int digit1 = num1.charAt(i) - '0';
			for(int j = m - 1; j >= 0; j--){
				int digit2 = num2.charAt(j) - '0';
				sum[i + j + 1] += digit1 * digit2;
				sum[i + j] += sum[i + j + 1] / 10;
				sum[i + j + 1] %= 10;
			}
		}

		int i = 0;
		while(sum[i] == 0){
            i++;
		}

		for(int j = i; j < sum.length; j++){
			answer += sum[j];
		}

		return answer;
	}
}
