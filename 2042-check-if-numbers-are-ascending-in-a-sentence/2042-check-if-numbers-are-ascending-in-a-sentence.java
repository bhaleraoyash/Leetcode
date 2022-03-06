class Solution {
    public boolean areNumbersAscending(String s) {
        int lastNumber = -1;
        
        String[] parts = s.split("\\s+");
        
        for(int i = 0; i < parts.length; i++){
            if(Character.isDigit(parts[i].charAt(0))){
                int temp = Integer.valueOf(parts[i]);
                if(lastNumber == -1){
                    lastNumber = temp;
                }
                else{
                    if(temp <= lastNumber){
                        return false;
                    }
                    lastNumber = temp;
                }
            }
        }
        
        return true;
    }
}