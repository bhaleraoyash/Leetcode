class SnapshotArray {

    List<Map<Integer, Integer>> snaps = new ArrayList<Map<Integer, Integer>>();
    int currentSnapId;
    
    public SnapshotArray(int length) {
        snaps.add(new HashMap<Integer, Integer>());    
    }
    
    public void set(int index, int val) {
        snaps.get(currentSnapId).put(index, val);
    }
    
    public int snap() {
        snaps.add(new HashMap<Integer, Integer>());
        return currentSnapId++;
    }
    
    public int get(int index, int snap_id) {
        for(int i = snap_id; i >= 0; i--){
            Integer val = snaps.get(i).get(index);
            if(val != null){
                return val;
            }
        }
        return 0;
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */