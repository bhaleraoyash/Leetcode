class Solution {
    public int findKthPositive(int[] arr, int k) {
        int[] missing = new int[k + 1];
        Set<Integer> arrSet = new HashSet<Integer>();
        int counter = 1;
        missing[0] = 0;

        for(Integer i : arr){
            arrSet.add(i);
        }

        for(int i = 1; i <= arr.length + k + 2; i++){
            if(!arrSet.contains(i) && counter < missing.length){
                missing[counter] = i;
                counter++;
            }
        }
        
        return missing[k];
    }
}
