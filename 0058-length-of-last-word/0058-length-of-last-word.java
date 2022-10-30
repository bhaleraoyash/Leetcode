class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        
        String parts[] = s.split(" ");
        
        return parts[parts.length - 1].trim().length();
    }
}