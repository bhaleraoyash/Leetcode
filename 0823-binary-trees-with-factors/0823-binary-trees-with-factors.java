class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        Map<Integer, Long> counter = new HashMap<Integer, Long>();
        long answer = 0l;
        
        for(int i = 0; i < arr.length; i++){
            long count = 1l;
            for(int j = 0; j < i; j++){
                if(arr[i] % arr[j] == 0 && counter.containsKey(arr[i] / arr[j])){
                    count += counter.get(arr[j]) * counter.get(arr[i] / arr[j]);
                }
            }
            counter.put(arr[i], count);
        }
        
        for(int i : counter.keySet()){
            answer += counter.get(i);
        }
        
        return (int)(answer % (1000000000 + 7));
    }
}