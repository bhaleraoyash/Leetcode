class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> indices = new HashMap<Integer, Integer>();
        int answer = 0;
        int left = 0;
        int right = 0;
        
        while(right < fruits.length){
            indices.put(fruits[right], right);
            if(indices.size() > 2){
                int min = Collections.min(indices.values());
                indices.remove(fruits[min]);
                left = min + 1;
            }
            answer = Math.max(answer, right - left + 1);
            right++;
        }
        
        return answer;
    }
}