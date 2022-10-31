class Solution {
    public boolean isStrobogrammatic(String num) {
        Map<Integer, Integer> numbers = new HashMap<Integer, Integer>();
        numbers.put(0, 0);
        numbers.put(1, 1);
        numbers.put(6, 9);
        numbers.put(9, 6);
        numbers.put(8, 8);
        
        String reverse = "";
        
        for(int i = 0; i < num.length(); i++){
            char c = num.charAt(i);
            int digit = Character.getNumericValue(c);
            if(numbers.containsKey(digit)){
                reverse = String.valueOf(numbers.get(digit)) + reverse;
            }
            else{
                return false;
            }
        }
        
        return reverse.equals(num);
    }
}