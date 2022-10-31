class MovingAverage {
    
    List<Double> numbers;
    int index = 0;
    double sum = 0;
    double windowSize;

    public MovingAverage(int size) {
        windowSize = size;
        numbers = new ArrayList<Double>();
    }
    
    public double next(int val) {
        double answer = 0;
        numbers.add(Double.valueOf(val));
        // System.out.println(numbers);
        sum += val;
        if(numbers.size() <= windowSize){
            // System.out.println("sum : " + sum);
            answer = sum / Double.valueOf(numbers.size());
        }
        else{
            sum -= numbers.get(index);
            index++;
            answer = sum / windowSize;
        }
        
        return answer;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */