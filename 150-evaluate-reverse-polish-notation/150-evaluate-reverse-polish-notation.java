class Solution{
	public int evalRPN(String[] tokens){
		Stack<Integer> numbers = new Stack<Integer>();

		for(int i = 0; i < tokens.length; i++){
			if(tokens[i].equals("+")){
				int num1 = numbers.pop();
				int num2 = numbers.pop();
				numbers.push(num1 + num2);
			}
			else if(tokens[i].equals("-")){
				int num1 = numbers.pop();
				int num2 = numbers.pop();
				numbers.push(num2 - num1);
			}
			else if(tokens[i].equals("*")){
				int num1 = numbers.pop();
				int num2 = numbers.pop();
				numbers.push(num1 * num2);
			}
			else if(tokens[i].equals("/")){
				int num1 = numbers.pop();
				int num2 = numbers.pop();
				numbers.push(num2 / num1);
			}
			else{
				numbers.push(Integer.valueOf(tokens[i]));
			}
		}
		
		return numbers.pop();
	}
}
