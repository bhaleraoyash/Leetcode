class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> counter = new HashMap<Integer, Integer>();
        Set<Integer> counts = new HashSet<Integer>();
        
        for(int num : arr){
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }
        
        counts.addAll(counter.values());
        
        return counter.size() == counts.size();
    }
}