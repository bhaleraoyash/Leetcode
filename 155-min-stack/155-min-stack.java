class MinStack {
    
    Stack<Integer> normalStack = new Stack<Integer>();
    Stack<Integer> minStack = new Stack<Integer>();

    public MinStack() {
        
    }
    
    public void push(int val) {
        if(minStack.isEmpty() || val <= minStack.peek()){
            minStack.push(val);
        }
        normalStack.push(val);
    }
    
    public void pop() {
        if(normalStack.peek().equals(minStack.peek())){
            minStack.pop();
        }
        normalStack.pop();
    }
    
    public int top() {
        return normalStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */