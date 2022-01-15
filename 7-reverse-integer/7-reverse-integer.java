class Solution {
    public int reverse(int x) {
        String sb = new StringBuilder().append(Math.abs(x)).reverse().toString();
        try{
            return (x < 0) ? Integer.parseInt(sb) * -1 : Integer.parseInt(sb);
        }
        catch(NumberFormatException e){
            return 0;
        }
    }
}