class Solution {
    public boolean checkIfPangram(String sentence) {
        Set<Character> alphabets = new HashSet<Character>();
        
        for(int i = 0; i < sentence.length(); i++){
            char c = sentence.charAt(i);
            alphabets.add(c);
        }
        
        return alphabets.size() == 26;
    }
}