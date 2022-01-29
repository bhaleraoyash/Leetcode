class StockPrice {

    PriorityQueue<Pair<Integer,Integer>> maxHeap;
    PriorityQueue<Pair<Integer,Integer>> minHeap;
    Map<Integer,Integer> map;
    int lastestTimeStamp = 0;
    
    public StockPrice() {
     maxHeap = new PriorityQueue<Pair<Integer,Integer>>((p1,p2) ->
                                                         p2.getValue()-p1.getValue());
         minHeap = new PriorityQueue<Pair<Integer,Integer>>((p1,p2)->
                                                         p1.getValue()-p2.getValue()); 
        map = new HashMap();
    }
    
    public void update(int timestamp, int price) {
        map.put(timestamp,price);
        maxHeap.add(new Pair<Integer,Integer>(timestamp,price));
        minHeap.add(new Pair<Integer,Integer>(timestamp,price));
        lastestTimeStamp = Math.max(lastestTimeStamp,timestamp);

    }
    
    public int current() {
        return map.get(lastestTimeStamp);
    }
    
    public int maximum() {
        while(!map.get(maxHeap.peek().getKey()).equals(maxHeap.peek().getValue())){
          maxHeap.poll();  
        }
        return maxHeap.peek().getValue();
    }
    
    public int minimum() {
      while(!map.get(minHeap.peek().getKey()).equals(minHeap.peek().getValue())){
          minHeap.poll();  
        }
        return minHeap.peek().getValue();   
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */