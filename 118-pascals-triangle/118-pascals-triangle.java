class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        int count = 1;
        
        for(int i = 0; i < numRows; i++){
            List<Integer> temp = new ArrayList<Integer>();
            for(int j = 0; j < count; j++){
                if(j == 0 || j == count - 1){
                    temp.add(1);
                }
                else{
                    temp.add(answer.get(i-1).get(j - 1) + answer.get(i - 1).get(j));
                }
            }
            answer.add(temp);
            count++;
        }
        
        return answer;
    }
}