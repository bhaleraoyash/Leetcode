class Solution {
    public int[] findOriginalArray(int[] changed) {
        if(changed.length % 2 != 0){
            return new int[0];
        }
        int[] answer = new int[changed.length];
        Map<Integer, Integer> counter = new HashMap<Integer, Integer>();
        
        Arrays.sort(changed);
        
        int j = 0;
        for(int i = changed.length - 1; i >= 0; i--){
            int single = changed[i];
            int twice = single * 2;
            if(counter.containsKey(twice) && counter.get(twice) > 0){
                answer[j] = single;
                counter.put(twice, counter.get(twice) - 1);
                j++;
            }
            else{
                counter.put(single, counter.getOrDefault(single, 0) + 1);
            }
        }
        
        return j == changed.length / 2 ? Arrays.copyOfRange(answer, 0, j) : new int[0];
    }
}
