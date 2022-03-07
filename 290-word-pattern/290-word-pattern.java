class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<String, Character> stringChar = new HashMap<String, Character>();
        Map<Character, String> charString = new HashMap<Character, String>();
        
        String[] parts = s.split("\\s+");
        
        if(pattern.length() != parts.length){
            return false;
        }
        
        for(int i = 0; i < parts.length; i++){
            char c = pattern.charAt(i);
            if(!charString.containsKey(c)){
                if(stringChar.containsKey(parts[i])){
                    return false;
                }
                else{
                    stringChar.put(parts[i], c);
                    charString.put(c, parts[i]);
                }
            }
            else{
                if(!charString.get(c).equals(parts[i])){
                    return false;
                }
            }
        }
        
        return true;
    }
}