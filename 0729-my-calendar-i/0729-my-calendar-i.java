class MyCalendar {

    TreeMap<Integer, Integer> bookings;
    
    public MyCalendar() {
         bookings = new TreeMap<Integer, Integer>();
    }
    
    public boolean book(int start, int end) {
        if(bookings.floorEntry(start) != null && start < bookings.floorEntry(start).getValue()){
            return false;
        }
        if(bookings.ceilingEntry(start) != null && end > bookings.ceilingEntry(start).getKey()){
            return false;
        }
        bookings.put(start, end);
        
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */