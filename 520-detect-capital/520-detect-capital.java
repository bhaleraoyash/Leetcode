class Solution {
    public boolean detectCapitalUse(String word) {
        int numberCap = 0;
        
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(Character.isUpperCase(c)){
                numberCap++;
            }
        }
        
        if(numberCap == word.length() || numberCap == 0){
            return true;
        }
        if(numberCap == 1 && Character.isUpperCase(word.charAt(0))){
            return true;
        }
        return false;
    }
}