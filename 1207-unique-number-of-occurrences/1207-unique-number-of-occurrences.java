class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> counter = new HashMap<Integer, Integer>();
        Set<Integer> occurences = new HashSet<Integer>();
        
        for(int i : arr){
            counter.put(i, counter.getOrDefault(i, 0) + 1);
        }
        
        for(int i : counter.values()){
            occurences.add(i);
        }
        
        return occurences.size() == counter.size();
    }
}