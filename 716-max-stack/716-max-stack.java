class MaxStack {

    Stack<Integer> newStack = new Stack<Integer>();
    Stack<Integer> maxStack = new Stack<Integer>();
    
    public MaxStack() {
        
    }
    
    public void push(int x) {
        int max = maxStack.isEmpty() ? x : maxStack.peek();
        maxStack.push(max > x ? max : x);
        newStack.push(x);
    }
    
    public int pop() {
        maxStack.pop();
        return newStack.pop();
    }
    
    public int top() {
        return newStack.peek();
    }
    
    public int peekMax() {
        return maxStack.peek();
    }
    
    public int popMax() {
        int max = peekMax();
        Stack<Integer> temp = new Stack<Integer>();
        
        while(top() != max){
            temp.push(pop());
        }
        pop();
        
        while(!temp.isEmpty()){
            push(temp.pop());
        }
        
        return max;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */