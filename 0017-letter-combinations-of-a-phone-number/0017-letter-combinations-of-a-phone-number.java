class Solution {
    public List<String> letterCombinations(String digits) {
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
            char c = digits.charAt(i);
            int digit = Character.getNumericValue(c);
            while(answer.peek().length() == i){
                String current = answer.remove();
                for(char letter : mapping.get(digit).toCharArray()){
                    answer.add(current + letter);
                }
            }
        }
        
        return answer;
    }
}