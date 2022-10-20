class Solution{
	public List<String> letterCombinations(String digits){
		LinkedList<String> answer = new LinkedList<String>();
        if(digits.length() == 0){
            return answer;
        }
        answer.add("");
		Map<Integer, String> mapping = new HashMap<Integer, String>();
		mapping.put(2, "abc");
        mapping.put(3, "def");
        mapping.put(4, "ghi");
        mapping.put(5, "jkl");
        mapping.put(6, "mno");
        mapping.put(7, "pqrs");
        mapping.put(8, "tuv");
        mapping.put(9, "wxyz");
        
        for(int i = 0; i < digits.length(); i++){
            int current_digit = Character.getNumericValue(digits.charAt(i));
            while(answer.peek().length() == i){
                String current_string = answer.remove();
                for(char c : mapping.get(current_digit).toCharArray()){
                    answer.add(current_string + c);
                }
            }
        }
        
        return answer;
    }
}                