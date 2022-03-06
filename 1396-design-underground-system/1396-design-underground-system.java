class UndergroundSystem {

    Map<Integer, Arrival> arrivals = new HashMap<Integer, Arrival>();
    Map<String, Average> averages = new HashMap<String, Average>();
    
    public UndergroundSystem() {
        
    }
    
    public void checkIn(int id, String stationName, int t) {
        Arrival in = new Arrival();
        in.id = id;
        in.stationName = stationName;
        in.t = t;
        arrivals.put(id, in);
    }
    
    public void checkOut(int id, String stationName, int t) {
        Arrival in = arrivals.get(id);
        int diff = t - in.t;
        arrivals.remove(id);
        String temp = in.stationName + "," + stationName;
        
        if(averages.containsKey(temp)){
            Average a = averages.get(temp);
            Average b = new Average();
            b.totalTime = a.totalTime + diff;
            b.numberOfTrips = a.numberOfTrips + 1;
            averages.put(temp, b);
        }
        else{
            Average a = new Average();
            a.totalTime = diff;
            a.numberOfTrips = 1;
            averages.put(temp, a);
        }
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String temp = startStation + "," + endStation;
        Average a = averages.get(temp);
        
        return a.totalTime / a.numberOfTrips;
    }
}

class Arrival{
    public int id;
    public String stationName;
    public int t;
}

class Average{
    public double totalTime;
    public double numberOfTrips;
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */