class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        
        return makeMap(s).equals(makeMap(t));
    }
    
    public Map<Character, Integer> makeMap(String input){
        char[] chars = input.toCharArray();
        Map<Character, Integer> counter = new HashMap<Character, Integer>();
        
        for(int i = 0; i < chars.length; i++){
            counter.put(chars[i], counter.getOrDefault(chars[i], 1) + 1);
        }
        return counter;
    }
}
