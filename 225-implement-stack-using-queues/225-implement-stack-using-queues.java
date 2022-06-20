// Space Complexity = O(N)
// Time Complexity = O(1)
class MyStack {
    LinkedList<Integer> intQueue;
    /** Initialize your data structure here. */
    public MyStack() {
        intQueue = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        intQueue.add(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return intQueue.pollLast();
    }
    
    /** Get the top element. */
    public int top() {
        return intQueue.getLast();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return intQueue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */