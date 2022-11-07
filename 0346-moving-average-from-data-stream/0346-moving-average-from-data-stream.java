class MovingAverage {

    List<Double> numbers = new ArrayList<Double>();
    int size = 0;
    double sum = 0;
    int index = 0;
    
    public MovingAverage(int size) {
        this.size = size;
    }
    
    public double next(int val) {
        sum += (double)val;
        numbers.add((double)val);
        if(numbers.size() > size){
            sum -= numbers.get(index);
            index++;
            return sum / size;
        }
        return sum / numbers.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */