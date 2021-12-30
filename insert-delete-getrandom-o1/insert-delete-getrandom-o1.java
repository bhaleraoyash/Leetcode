class RandomizedSet {

    Map<Integer, Integer> index = new HashMap<Integer, Integer>();
    List<Integer> elements = new ArrayList<Integer>();
    
    public RandomizedSet() {
        
    }
    
    public boolean insert(int val) {
        if(index.containsKey(val)){
            return false;
        }	
        index.put(val, elements.size());
        elements.add(elements.size(), val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!index.containsKey(val)){
            return false;
        }
        int lastElement = elements.get(elements.size() - 1);
        int idx = index.get(val);
        elements.set(idx, lastElement);
        index.put(lastElement, idx);
        elements.remove(elements.size() - 1);
        index.remove(val);
        return true;
    }
    
    public int getRandom() {
        Random rand = new Random();
        return elements.get(rand.nextInt(elements.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
