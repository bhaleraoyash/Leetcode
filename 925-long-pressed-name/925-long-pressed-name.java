class Solution {
    public boolean isLongPressedName(String name, String typed) {
        if(name.length() > typed.length()) return false;
        
        int n = 0;
        int t = 0;
        while(t < typed.length()){
            if(n < name.length() && name.charAt(n) == typed.charAt(t)){
                n++;
            }
            else if(t == 0 || typed.charAt(t) != typed.charAt(t - 1)){
                return false;
            }
            t++;
        }
        return n == name.length();
    }
}