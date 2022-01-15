class MyCalendar {

    List<int[]> intervals = new ArrayList<int[]>();
    
    public MyCalendar() {
        
    }
    
    public boolean book(int start, int end) {
        for(int[] interval : intervals){
            if(interval[0] < end && start < interval[1]){
                return false;
            }
        }
        int[] temp = new int[]{start, end};
        intervals.add(temp);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */