class SnapshotArray {

    List<TreeMap<Integer, Integer>> snaps = new ArrayList<TreeMap<Integer, Integer>>();
    int currentSnapId;
    
    public SnapshotArray(int length) {
        for(int i = 0; i < length; i++){
            snaps.add(new TreeMap<Integer, Integer>());
            snaps.get(i).put(0, 0);
        }
        currentSnapId = 0;
    }
    
    public void set(int index, int val) {
        snaps.get(index).put(currentSnapId, val);
    }
    
    public int snap() {
        return currentSnapId++;
    }
    
    public int get(int index, int snap_id) {
        return snaps.get(index).floorEntry(snap_id).getValue();
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */