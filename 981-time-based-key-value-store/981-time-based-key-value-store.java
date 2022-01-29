class TimeMap {

    Map<String, TreeMap<Integer, String>> store;
    
    public TimeMap() {
        store = new HashMap<String, TreeMap<Integer, String>>();
    }
    
    public void set(String key, String value, int timestamp) {
        store.putIfAbsent(key, new TreeMap<>());
        store.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if(!store.containsKey(key)){
            return "";
        }
        Integer prevTimestamp = store.get(key).floorKey(timestamp);
        return prevTimestamp != null ? store.get(key).get(prevTimestamp) : "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */