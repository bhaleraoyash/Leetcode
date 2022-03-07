class Solution {
    public String capitalizeTitle(String title) {
        String answer = "";
        String[] parts = title.split("\\s+");
        
        for(int i = 0; i < parts.length; i++){
            if(i == 0){
                if(parts[i].length() > 2){
                    String temp = parts[i].toLowerCase();
                    String first = temp.charAt(0) + "";
                    answer += first.toUpperCase() + temp.substring(1);
                }
                else{
                    answer += parts[i].toLowerCase();
                }
            }
            else{
                if(parts[i].length() > 2){
                    String temp = parts[i].toLowerCase();
                    String first = temp.charAt(0) + "";
                    answer += " " + first.toUpperCase() + temp.substring(1);
                }
                else{
                    answer += " " + parts[i].toLowerCase();
                }
            }
        }
        
        return answer;
    }
}