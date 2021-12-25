class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> counter = new HashMap<Integer, Integer>();
        int[] answer = new int[2];

        for(int i = 0; i < numbers.length; i++){
            counter.put(numbers[i], i);
        }

        for(int i = 0; i < numbers.length; i++){
            int complement = target - numbers[i];
            if(counter.containsKey(complement) && counter.get(complement) != i){
                if(i + 1 < counter.get(complement) + 1){
                    answer[0] = i + 1;
                    answer[1] = counter.get(complement) + 1;
                }
                else{
                    answer[1] = i + 1;
                    answer[0] = counter.get(complement) + 1;
                }
            }
        }
        return answer;
    }
}
