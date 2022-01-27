class Solution {
    public String capitalizeTitle(String title) {
        String[] words = title.split(" ");
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < words.length; i++){
            String temp = "";
            if(words[i].length() <= 2){
                temp = words[i].toLowerCase();
            }
            else{
                temp = words[i].substring(0, 1).toUpperCase() + words[i].substring(1).toLowerCase();
            }
            words[i] = temp;
        }
        
        for(int i = 0; i < words.length; i++){
            if(i != words.length - 1){
                answer += words[i] + " ";
            }
            else{
                answer += words[i];
            }
        }
        
        return answer;
    }
}