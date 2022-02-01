class Logger {

    Map<String, Integer> checker;
    
    public Logger() {
        checker = new HashMap<String, Integer>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(!checker.containsKey(message)){
            checker.put(message, timestamp + 10);
            return true;
        }
        else{
            if(checker.get(message) > timestamp){
                return false;
            }
            else{
                checker.put(message, timestamp + 10);
                return true;
            }
        }
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */