class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        Set<Integer> checker = new HashSet<Integer>();
        List<Integer> answer = new ArrayList<Integer>();
        
        for(int i : nums){
            if(checker.contains(i)){
                answer.add(i);
            }
            else{
                checker.add(i);
            }
        }
        
        return answer;
    }
}