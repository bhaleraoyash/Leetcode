class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> answer = new ArrayList<Integer>();
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        int count = 1;
        
        for(int i = 0; i < rowIndex + 1; i++){
            List<Integer> temp = new ArrayList<Integer>();
            for(int j = 0; j < count; j++){
                if(j == 0 || j == count - 1){
                    temp.add(1);
                }
                else{
                    temp.add(triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j));
                }
            }
            triangle.add(temp);
            count++;
        }
        
        return triangle.get(rowIndex);
    }
}