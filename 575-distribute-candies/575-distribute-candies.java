class Solution {
    public int distributeCandies(int[] candyType) {
        int n = candyType.length;
        Set<Integer> types = new HashSet<Integer>();
        
        for(int i = 0; i < n; i++){
            types.add(candyType[i]);
        }
        int number = types.size();
        int can = n / 2;
        
        if(number == can){
            return can;
        }
        else if(number < can){
            return number;
        }
        else{
            return can;
        }
    }
}