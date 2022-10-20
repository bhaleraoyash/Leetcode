class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> counter = new HashMap<Integer, Integer>();
        Set<Integer> unique = new HashSet<Integer>();
        
        for(int i = 0; i < arr.length; i++){
            counter.put(arr[i], counter.getOrDefault(arr[i], 0) + 1);
        }
        
        unique.addAll(counter.values());
        
        return unique.size() == counter.size();
    }
}