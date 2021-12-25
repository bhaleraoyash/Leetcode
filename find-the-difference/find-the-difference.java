class Solution {
    public char findTheDifference(String s, String t) {
        Map<Character, Integer> counter = new HashMap<Character, Integer>();     
        char answer = t.charAt(0);

        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);

            if(counter.containsKey(c)){
                counter.put(c, counter.get(c) + 1);
            }
            else{
                counter.put(c, 1);
            }
        }

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if(counter.containsKey(c)){
                counter.put(c, counter.get(c) - 1);
            }
        }  

        for(char c : counter.keySet()){
            if(counter.get(c) != 0){
                answer = c;
            }
        }
        return answer;
    }
}
