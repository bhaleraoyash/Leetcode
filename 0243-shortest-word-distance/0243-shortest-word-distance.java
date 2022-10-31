class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        Map<String, List<Integer>> indices = new HashMap<String, List<Integer>>();
        int answer = Integer.MAX_VALUE;
        
        for(int i = 0; i < wordsDict.length; i++){
            if(indices.containsKey(wordsDict[i])){
                indices.get(wordsDict[i]).add(i);
            }
            else{
                List<Integer> temp = new ArrayList<Integer>();
                temp.add(i);
                indices.put(wordsDict[i], temp);
            }
        }
        
        List<Integer> list1 = indices.get(word1);
        List<Integer> list2 = indices.get(word2);
        
        for(int index1 : list1){
            for(int index2 : list2){
                int distance = Math.abs(index1 - index2);
                answer = Math.min(answer, distance);
            }
        }
        
        return answer;
    }
}