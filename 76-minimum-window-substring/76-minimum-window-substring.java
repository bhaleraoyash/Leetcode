class Solution {
    public String minWindow(String s, String t) {
        if(s == null || t == null || s.isEmpty() || t.isEmpty()){
            return "";
        }
        
        Map<Character, Integer> counter = new HashMap<Character, Integer>();
        
        for(char c : t.toCharArray()){
            counter.put(c, counter.getOrDefault(c, 0) + 1);
        }
        
        int i = 0;
        int j = 0;
        int count = counter.size();
        int left = 0;
        int right = s.length() - 1;
        int min = s.length();
        boolean found = false;
        
        while(j < s.length()){
            char endChar = s.charAt(j++);
            if(counter.containsKey(endChar)){
                counter.put(endChar, counter.get(endChar) - 1);
                if(counter.get(endChar) == 0){
                    count--;
                }
            }
            if(count > 0){
                continue;
            }
            
            while(count == 0){
                char startChar = s.charAt(i++);
                if(counter.containsKey(startChar)){
                    counter.put(startChar, counter.get(startChar) + 1);
                    if(counter.get(startChar) > 0){
                        count++;
                    }
                }   
            }
            
            if((j - i) < min){
                left = i;
                right = j;
                min = j - i;
                found = true;
            }
        }
        
        return found == true ? s.substring(left - 1, right) : "";
    }
}