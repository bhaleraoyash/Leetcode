class Solution {
    public int countElements(int[] arr) {
        Set<Integer> elems = new HashSet<Integer>();
        int ans = 0;
        
        for(int i : arr){
            elems.add(i);
        }
        
        for(int i : arr){
            if(elems.contains(i + 1)){
                ans++;
            }
        }
        
        return ans;
    }
}