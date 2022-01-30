class TwoSum {

    List<Integer> nums;
    
    public TwoSum() {
        nums = new ArrayList<Integer>();
    }
    
    public void add(int number) {
        nums.add(number);
    }
    
    public boolean find(int value) {
        Map<Integer, Integer> index = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < nums.size(); i++){
            int complement = value - nums.get(i);
            if(index.containsKey(complement) && index.get(complement) != i){
                return true;
            }
            else{
                index.put(nums.get(i), i);
            }
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */