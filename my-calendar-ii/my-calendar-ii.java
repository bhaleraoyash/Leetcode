class MyCalendarTwo {

    List<int[]> first = new ArrayList<int[]>();
    List<int[]> second = new ArrayList<int[]>();
    
    public MyCalendarTwo() {
        
    }
    
    public boolean book(int start, int end) {
        for(int[] interval : first){
            if(start < interval[1] && interval[0] < end){
                return false;
            }
        }
        
        for(int[] overlap : second){
            if(start < overlap[1] && overlap[0] < end){
                int[] temp = new int[]{Math.max(start, overlap[0]), Math.min(end, overlap[1])};
                first.add(temp);
            }
        }
        
        int[] temp2 = new int[]{start, end};
        second.add(temp2);
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */