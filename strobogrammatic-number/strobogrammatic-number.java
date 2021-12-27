class Solution {
    public boolean isStrobogrammatic(String num) {
        Map<Integer, Integer> rotated = new HashMap<Integer, Integer>();
        rotated.put(6, 9);
        rotated.put(0, 0);
        rotated.put(9, 6);
        rotated.put(1, 1);
        rotated.put(8, 8);
        String answer = "";
        
        for(int i = 0; i < num.length(); i++){
            char c = num.charAt(i);
            int number = Character.getNumericValue(c);
            if(rotated.containsKey(number)){
                answer = rotated.get(number) + answer;
            }
        }
        System.out.println(answer);
        
        return num.equals(answer);
    }
}